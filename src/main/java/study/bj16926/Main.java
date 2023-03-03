package study.bj16926;

import java.util.*;
import java.io.*;

public class Main {

    static int N,M,R;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj16926/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int count = Math.min(N, M) / 2;

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < count; j++) {
                int temp = map[j][j];

                for(int k = j+1; k < M-j; k++) {
                    map[j][k-1] = map[j][k];
                }

                for(int k = j+1; k < N-j; k++) {
                    map[k-1][M-1-j] = map[k][M-1-j];
                }

                for(int k = M-2-j; k >= j; k--) {
                    map[N-1-j][k+1] = map[N-1-j][k];
                }

                for(int k = N-2-j; k >=j; k--) {
                    map[k+1][j] = map[k][j];
                }

                map[j+1][j] = temp;
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}