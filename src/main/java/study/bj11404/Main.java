package study.bj11404;

import java.util.*;
import java.io.*;

public class Main {

    static int n, m;

    static int[][] map;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj11404/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i==j) continue;
                map[i][j] = 1_000_000;
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int value = Integer.parseInt(st.nextToken());

            map[start][end] = Math.min(map[start][end], value);
        }

        //거쳐가는 노드
        for(int k = 0; k < n; k++) {
            //시작노드
            for(int i = 0; i < n; i++) {
                //도착노드
                for(int j = 0; j < n; j++) {
                    if(map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                sb.append(map[i][j]);
                sb.append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}