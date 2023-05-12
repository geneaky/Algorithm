package study.bj2156;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj2156/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];

        for(int i = 1; i < n; i++) {
            if(i == 1) {
                dp[1] = arr[0] + arr[1];
                continue;
            }
            if(i == 2) {
                dp[2] = Math.max(dp[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));
                continue;
            }
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+arr[i], dp[i-3] + arr[i-1] + arr[i]));
        }

        //n = 1 idx = 0, n = 2 idx = 1, n = 3 idx = 2
        System.out.println(dp[n-1]);
    }
}