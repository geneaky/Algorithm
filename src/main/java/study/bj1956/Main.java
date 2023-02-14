package study.bj1956;

import java.util.*;
import java.io.*;

public class Main {

    static int V,E;
    static int INF = Integer.MAX_VALUE;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1956/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        map = new int[V][V];

        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                map[i][j] = INF;
                if(i==j) {
                    map[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int value = Integer.parseInt(st.nextToken());

            map[start][end] = value;
        }

        // 경유지 k
        for(int k = 0; k < V; k++) {
            // 출발지 i
            for(int i = 0; i < V; i++) {
                // 도착지 j
                for(int j = 0; j < V; j++) {
                    if(map[i][k] != INF && map[k][j] != INF && map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                if(i!=j && map[i][j] != INF && map[j][i] != INF && dist[i] > map[i][j] + map[j][i]) {
                    dist[i] = map[i][j] + map[j][i];
                }
            }
        }

        Arrays.sort(dist);

        if(dist[0] >= INF) {
            System.out.println(-1);
        }else{
            System.out.println(dist[0]);
        }
    }
}