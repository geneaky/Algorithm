package study.bj2096;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj2096/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][3];
        int[][] max = new int[N][3];
        int[][] min = new int[N][3];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        max[0][0] = map[0][0];
        max[0][1] = map[0][1];
        max[0][2] = map[0][2];

        min[0][0] = map[0][0];
        min[0][1] = map[0][1];
        min[0][2] = map[0][2];

        for(int i = 1; i < N; i++) {
            max[i][0] = map[i][0] + Math.max(max[i-1][0], max[i-1][1]);
            max[i][1] = map[i][1] + Math.max(max[i-1][0], Math.max(max[i-1][1], max[i-1][2]));
            max[i][2] = map[i][2] + Math.max(max[i-1][2], max[i-1][1]);
        }

        for(int i = 1; i < N; i++) {
            min[i][0] = map[i][0] + Math.min(min[i - 1][0], min[i - 1][1]);
            min[i][1] = map[i][1] + Math.min(min[i - 1][0], Math.min(min[i - 1][1], min[i-1][2]));
            min[i][2] = map[i][2] + Math.min(min[i - 1][1], min[i - 1][2]);
        }

        System.out.print(Math.max(max[N-1][0], Math.max(max[N-1][1], max[N-1][2])));
        System.out.print(" ");
        System.out.print(Math.min(min[N-1][0], Math.min(min[N-1][1], min[N-1][2])));
    }
}