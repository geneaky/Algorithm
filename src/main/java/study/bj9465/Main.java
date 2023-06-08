package study.bj9465;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int T;

    static int N;

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj9465/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[2][N+1];

            int[][] dp = new int[2][N+1];
            for(int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 1; k <= N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for(int j = 2; j <= N; j++) {
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + arr[1][j];
            }

            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }
}