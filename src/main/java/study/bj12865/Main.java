package study.bj12865;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj12865/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][2];
        int[][] dp = new int[N + 1][K+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[i][0] = w;
            arr[i][1] = v;
        }

        for(int i = 1; i <= K; i++) {
            for(int j = 1; j <= N; j++) {
                dp[j][i] = dp[j - 1][i];
                if(i - arr[j][0]>= 0) {
                    dp[j][i] = Math.max(dp[j - 1][i], arr[j][1] + dp[j - 1][i - arr[j][0]]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}