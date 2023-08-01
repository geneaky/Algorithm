package study.bj1005;

import java.util.*;
import java.io.*;

public class Main {

    static int N,M;
    static int[][] arr, dp;
    static int[] ty = {0, 0, 1, -1};
    static int[] tx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1005/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[M+1][N+1];
        dp = new int[M+1][N+1];

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(1,1));
    }

    private static int dfs(int x, int y) {
        if(x == M && y == N) {
            return 1;
        }

        if(dp[x][y] != 0) {
            return dp[x][y];
        }

        dp[x][y] = 0;
        for(int i = 0; i < 4; i++) {
            int xx = x + tx[i];
            int yy = y + ty[i];

            if(xx < 1 || xx > M || yy < 1 || yy > N) {
                continue;
            }

            if(arr[x][y] > dp[xx][yy]) {
                arr[x][y] += dfs(xx, yy);
            }
        }

        return dp[x][y];
    }
}