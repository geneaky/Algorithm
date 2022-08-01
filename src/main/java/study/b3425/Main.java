package study.b3425;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/study/b3425/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<String> queue = new LinkedList<>();
        List<Stack<Long>> stackList = new ArrayList<>();
        long n = 0;
        String s = br.readLine();

        while (!s.equals("QUIT")) {
            if(s.equals("")) {
                start(queue,stackList,n);
                print(stackList);
                queue = new LinkedList<>();
                stackList = new ArrayList<>();
                s = br.readLine();
                continue;
            }

            //명령어
            while (s.matches("^[A-Z].*")) {
                queue.offer(s);
                s = br.readLine();
            }
            n = Long.parseLong(s);
            s = br.readLine();
            //입력
            while (s.matches("^-?[0-9].*")){
                long number = Long.parseLong(s);
                Stack<Long> stack = new Stack<>();
                stack.push(number);
                stackList.add(stack);

                s = br.readLine();
            }
        }



    }

    private static void print(List<Stack<Long>> stackList) {
        for (Stack<Long> stack : stackList) {
            if(stack.size() != 1 ||stack.peek() == null) {
                System.out.println("ERROR");
            }else{
                System.out.println(stack.pop());
            }
        }

        System.out.println();
    }

    private static void start(Queue<String> queue, List<Stack<Long>> stackList, long n) {

        while(!queue.isEmpty()) {
            String command = queue.poll();
            if (command.equals("END")) {
                break;
            }

            for(int i = 0; i < n; i++) {
                Stack<Long> stack = stackList.get(i);
                if(!stack.isEmpty() && stack.peek() == null) {
                    continue;
                }
                try {
                    switch(command) {
                        case "POP":
                            pop(stack);
                            break;
                        case "INV":
                            inv(stack);
                            break;
                        case "DUP":
                            dup(stack);
                            break;
                        case "SWP":
                            swp(stack);
                            break;
                        case "ADD":
                            add(stack);
                            break;
                        case "SUB":
                            sub(stack);
                            break;
                        case "MUL":
                            mul(stack);
                            break;
                        case "DIV":
                            div(stack);
                            break;
                        case "MOD":
                            mod(stack);
                            break;
                        default:
                            numX(stack, command);
                            break;
                    }
                } catch (Exception exception) {
                    stack.push(null);
                }
            }
        }
    }

    public static void numX(Stack<Long> stack, String num_x) {
        String num = num_x.replace("NUM ", "");
        Long number = Long.parseLong(num);

        //x 범위
        if(Math.abs(number) > Math.pow(10,9)) {
            stack.push(null);
            return;
        }
        stack.push(number);
    }

    public static void pop(Stack<Long> stack) throws Exception{
        stack.pop();
    }

    public static void inv(Stack<Long> stack) throws Exception{
        long top = stack.pop();

        if(Math.abs(top*-1) > Math.pow(10,9)) {
            stack.push(null);
            return;
        }
        stack.push(top*-1);
    }

    public static void dup(Stack<Long> stack) throws Exception{
        stack.push(stack.peek());
    }

    public static void swp(Stack<Long> stack) throws Exception{
        long first = stack.pop();
        long second = stack.pop();

        stack.push(first);
        stack.push(second);
    }


    public static void add(Stack<Long> stack) throws Exception{
        long first = stack.pop();
        long second = stack.pop();

        long result = first + second;

        if(Math.abs(result) > Math.pow(10,9)) {
            stack.push(null);
            return;
        }

        stack.push(result);
    }

    public static void sub(Stack<Long> stack) throws Exception{
        long first = stack.pop();
        long second = stack.pop();

        long result = second - first;

        if (Math.abs(result) > Math.pow(10, 9)) {
            stack.push(null);
            return;
        }
        stack.push(result);
    }

    public static void mul(Stack<Long> stack) throws Exception{
        long first = stack.pop();
        long second = stack.pop();

        long result = first * second;

        if(Math.abs(result) > Math.pow(10,9)){
            stack.push(null);
            return;
        }
        stack.push(result);
    }

    public static void div(Stack<Long> stack) throws Exception{
        long first = stack.pop();
        long second = stack.pop();

        if(first == 0) {
            stack.push(null); //ERROR
            return;
        }

        long result = Math.abs(second) / Math.abs(first);

        if((first > 0 && second < 0) || (first < 0 && second >0)) {
            result *= -1;
        }

        if(Math.abs(result) > Math.pow(10,9)) {
            stack.push(null);
            return;
        }
        stack.push(result);
    }

    public static void mod(Stack<Long> stack) throws Exception{
        long first = stack.pop();
        long second = stack.pop();

        if(first == 0) {
            stack.push(null); //ERROR
            return;
        }

        long result = Math.abs(second) % Math.abs(first);

        if(second < 0) {
            result *= -1;
        }

        if(Math.abs(result) > Math.pow(10,9)) {
            stack.push(null);
            return;
        }

        stack.push(result);
    }

    //숫자가 부족해서 연산을 수행할 수 없을 때 -> try catch로 묶어서 처리

}
