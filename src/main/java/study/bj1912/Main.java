package study.bj1912;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1912/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = numbers[0];
        int max = numbers[0];

        for(int i = 1; i < n; i ++) {
            dp[i] = Math.max(dp[i - 1] + numbers[i], numbers[i]);

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}