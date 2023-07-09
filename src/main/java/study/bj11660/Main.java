package study.bj11660;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj11660/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][N + 1];
        int[][] dp = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] from = new int[M][2];
        int[][] to = new int[M][2];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from[i][0] = Integer.parseInt(st.nextToken());
            from[i][1] = Integer.parseInt(st.nextToken());
            to[i][0] = Integer.parseInt(st.nextToken());
            to[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1]) + map[i][j];
            }
        }

        for(int i = 0; i < M; i++) {
            if (from[i][0] == to[i][0] && from[i][1] == to[i][1]) {
                System.out.println(map[from[i][0]][from[i][1]]);
                continue;
            }

            int ret = dp[to[i][0]][to[i][1]] - (dp[from[i][0] -1][to[i][1]] + dp[to[i][0]][from[i][1] -1] - dp[from[i][0] -1][from[i][1] -1]);
            System.out.println(ret);
        }
    }
}