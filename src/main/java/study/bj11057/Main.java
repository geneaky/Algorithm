package study.bj11057;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj11057/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][10];

        for(int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

//        for(int i = 2; i <= N; i++) {
//            for(int j = 0; j < 10; j++) {
//                dp[i][j] = (dp[i-1][j] * (10 - j)) % 10007;
//            }
//        }

        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = j; k < 10; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }


        System.out.println(dp[N][0]);
    }
}