package study.bj10844;

import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj10844/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N+1][10];

        long mod = 1_000_000_000;

        for(int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 0; j < 10; j++) {
                if(j == 0) {
                    dp[i][j] = (dp[i-1][j+1]) % mod;
                }else if (j == 9) {
                    dp[i][j] = (dp[i-1][j-1]) % mod;
                }else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
                }
            }
        }

        long sum = 0;
        for(int i = 0; i <10; i++) {
            sum += dp[N][i];
        }

        System.out.println(sum%mod);
    }
}