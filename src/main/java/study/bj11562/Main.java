package study.bj11562;

import java.util.*;
import java.io.*;

public class Main {
    static int INF = 987654321;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj11562/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1][N + 1];

        // dist 배열 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        // 입력 받은 도로 정보로 dist 배열 갱신
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (b == 0) { // 일방통행인 경우
                dist[u][v] = 0;
                dist[v][u] = 1;
            } else { // 양방향인 경우
                dist[u][v] = 0;
                dist[v][u] = 0;
                dist[u][u] = 0;
                dist[v][v] = 0;
            }
        }

        // 플로이드-와샬 알고리즘을 이용해 dist 배열 갱신
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int K = Integer.parseInt(br.readLine());

        // 출력
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            System.out.println(dist[u][v]);
        }
    }
}