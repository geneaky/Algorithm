package study.bj11727;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj11727/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 1;
        int count = 1;

        while(count++ != N) {
            if(count % 2 != 0) {
                result = (result*2 - 1) % 10_007;
            }else{
                result = (result*2 + 1) % 10_007;
            }
        }

        System.out.println(result);
    }
}