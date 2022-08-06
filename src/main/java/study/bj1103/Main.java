package study.bj1103;

import java.util.*;
import java.io.*;

public class Main {

    /*
    * dfs O(N+M) 예상
    * visited배열로 같은 곳을 또 방문하지 않고 돌아야함
    * */

    static int N, M;

    static char[][] graph;
    static boolean[][] visited;
    static int[][] dp;


    static int[] ty = {-1, 1, 0, 0};
    static int[] tx = {0, 0, -1, 1};
    static int max = 0;
    static int cnt = 0;

    static boolean isInfinite;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1103/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        visited = new boolean[N][M];
        dp = new int[N][M];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        isInfinite = false;
        visited[0][0] = true;
        dfs(0, 0, 1);

        if(isInfinite) {
            System.out.println(-1);
        } else {
            System.out.println(max);
        }
    }

    private static void dfs(int y, int x, int cnt) {
        if(cnt > max) {
            max = cnt;
        }

        dp[y][x] = cnt;

        for(int i = 0; i < 4; i++) {
            int ny = y + ty[i] * (graph[y][x] - '0');
            int nx = x + tx[i] * (graph[y][x] - '0');

            if(ny >= 0 && ny < N && nx >= 0 && nx < M && graph[ny][nx] != 'H') {
                if(visited[ny][nx]) {
                    isInfinite = true;
                    return;
                }

                if(dp[ny][nx] > cnt) {
                    continue;
                }

                visited[ny][nx] = true;
                dfs(ny,nx,cnt+1);
                visited[ny][nx] = false;
            }
        }
    }

}