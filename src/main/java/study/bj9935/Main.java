package study.bj9935;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj9935/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();
        Stack<Character> stack = new Stack();

        for(int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            boolean flag = true;
            if(stack.size() >= bomb.length()) {
                for(int j = 0; j < bomb.length(); j++) {
                    if(stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    for(int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Character character : stack) {
            sb.append(character);
        }

        if(sb.length() == 0) {
            System.out.println("FRULA");
        }else{
            System.out.println(sb.toString());
        }
    }
}