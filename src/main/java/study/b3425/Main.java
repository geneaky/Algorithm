package study.b3425;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    //연산 횟수 N (0 <= N <= 10,000) -> NlogN, N, logN, 1의 시간복잡도로 해결해야함

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/study/b3425/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<List<String>> pg = new ArrayList<>();
        List<Stack<Integer>> stackList = new ArrayList<>();
        while(true) {
            String program = br.readLine();
            if(program.equals("QUIT")){
                break;
            }
            List<String> list = new ArrayList<>();
            while(program.matches("^[A-Z]*$")) { // ["DUP","ADD","NUM 2","MOD"]
                list.add(program);
            }

            while(program.matches("^[0-9]*$")) { // ["1", "10", "50"]
                Stack<Integer> tempStack = new Stack<>();
                tempStack.push(Integer.parseInt(program));
                stackList.add(tempStack);
            }
        }
        //[ ["DUP","ADD","NUM 2","MOD"], ["DUP","ADD","NUM 2","MOD"], ,,,]
        //[ ["1", "10", "50"], ["1", "10", "50"], ,,,]
    }
}
