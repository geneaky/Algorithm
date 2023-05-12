package study.bj2579;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj2579/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[] numbers = new int[count+1];

        for(int i = 1; i < count+1; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[count+1];
        dp[1] = numbers[1];

        for(int i = 2; i < count+1; i++) {
            if(i==2) {
                dp[2] = numbers[1] + numbers[2];
            }else if(i==3) {
                dp[3] = Math.max(numbers[1], numbers[2]) + numbers[3];
            }else{
                dp[i] = Math.max(dp[i-3] + numbers[i-1], dp[i-2]) + numbers[i];
            }
        }

        System.out.println(dp[count]);
    }
}