package study.bj10026;

import java.util.*;
import java.io.*;

public class Main {

    static int N;

    static String[][] map;

    static boolean[][] rbvisited;
    static boolean[][] rgbvisited;

    static int rb = 0;
    static int rgb = 0;
    static int[] ty = {0, 0, -1, 1};
    static int[] tx = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj10026/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new String[N][N];
        rbvisited = new boolean[N][N];
        rgbvisited = new boolean[N][N];

        for(int i = 0 ; i < N; i++) {
            String[] split = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                map[i][j] = split[j];
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!rbvisited[i][j]) {
                    rbdfs(i,j, map[i][j]);
                    rb++;
                }

                if(!rgbvisited[i][j]) {
                    rgbdfs(i,j, map[i][j]);
                    rgb++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(rgb);
        sb.append(" ");
        sb.append(rb);
        System.out.println(sb.toString());
    }

    private static void rgbdfs(int i, int j, String s) {
        if(s.equals("R") && !map[i][j].equals("R")) {
            return;
        }else if(s.equals("G") && !map[i][j].equals("G")) {
            return;
        }else if(s.equals("B") && !map[i][j].equals("B")) {
            return;
        }

        rgbvisited[i][j] = true;

        for(int k = 0; k < 4; k++) {
            int next_y = i + ty[k];
            int next_x = j + tx[k];

            if(next_y >= 0 && next_y < N && next_x >= 0 && next_x < N && !rgbvisited[next_y][next_x]) {
                rgbdfs(next_y, next_x, s);
            }
        }
    }

    private static void rbdfs(int i, int j, String s) {
        if(s.equals("B") && !map[i][j].equals("B")) {
            return;
        }else if((s.equals("R") || s.equals("G")) && map[i][j].equals("B")) {
            return;
        }

        rbvisited[i][j] = true;

        for(int k = 0; k < 4; k++) {
            int next_y = i + ty[k];
            int next_x = j + tx[k];

            if(next_y >= 0 && next_y < N && next_x >= 0 && next_x < N && !rbvisited[next_y][next_x]) {
                rbdfs(next_y, next_x, s);
            }
        }
    }
}