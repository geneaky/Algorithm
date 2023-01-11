package study.bj10451;

import java.util.*;
import java.io.*;

public class Main {

    static int T;

    static int[] result;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj10451/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        result = new int[T];
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] map = new int[2][N+1];
            boolean[] visited = new boolean[N+1];
            st = new StringTokenizer(br.readLine());
            //initialize
            for(int j = 1; j < N+1; j++) {
                map[0][j] =  j;
                map[1][j] = Integer.parseInt(st.nextToken());
            }

            for(int j = 1; j < N+1; j++) {
                if(!visited[j]) {
                    dfs(j,i,visited, map);
                }
            }
        }

        for(int r : result) {
            System.out.println(r);
        }
    }

    private static void dfs(int j, int i, boolean[] visited, int[][] map) {
        if(visited[j]) {
            result[i] += 1;
            return;
        }

        visited[j] = true;

        dfs(map[1][j], i, visited, map);
    }
}