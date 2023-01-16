package study.bj1389;

import java.util.*;
import java.io.*;

public class Main {

    static int N,M;

    static long[][] map;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1389/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new long[N+1][N+1];

        for(int i = 1; i < N+1; i++) {
            for(int j = 1; j < N+1; j++) {
                if(i == j) {
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = 1;
            map[x][y] = 1;
        }

        // k 거쳐가는 노드
        for(int k = 1; k < N+1; k++) {
            //i 출발노드
            for(int i = 1; i < N+1; i++) {
                //j 도착노드
                for(int j = 1; j <N+1; j++) {
                    if(map[i][k] + map[k][j] < map[i][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int temp = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for(int i = 1; i < N+1; i++) {
            int t  = 0;
            for(int j = 1; j < N+1; j++) {
                t += map[i][j];
            }

            if(t < temp) {
                temp = t;
                result = i;
            }
        }

        System.out.println(result);
     }

}