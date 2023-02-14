package study.bj1507;

import java.util.*;
import java.io.*;

public class Main {

    static int N;

    static int[][] map;
    static int[][] temp;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1507/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        temp = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                temp[i][j] = map[i][j];
            }
        }

        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(i==j || i == k || j == k) {
                        continue;
                    }

                    if(map[i][j] == map[i][k] + map[k][j]) {
                        temp[i][j] = 0;
                    }

                    if(map[i][j] > map[i][k] + map[k][j]) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }

        int result = 0;

        for(int[] t : temp) {
            for(int p : t) {
                result += p;
            }
        }

        System.out.println(result/2);
    }
}