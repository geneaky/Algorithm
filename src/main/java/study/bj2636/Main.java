package study.bj2636;

import java.util.*;
import java.io.*;

public class Main {

    static int[] ty = {0,0,-1,1};
    static int[] tx = {1,-1,0,0};

    static int y = 0, x = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj2636/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        int[][] map = new int[y][x];

        for(int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < x; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                if((map[i][j] == 0 || map[i][j] ==2) && (i==0 || i==y-1 || j == 0 || j == x-1)) {
                    firstCheck(map, i, j);
                }
            }
        }

        int time = 0;
        int result_count = 0;
        int count = 3;
        while(true) {
            boolean[][] visited = new boolean[y][x];
            boolean flag = false;
            for(int i = 0; i < y; i++) {
                for(int j = 0; j < x; j++) {
                    if(map[i][j] == count-1) {
                        for(int k = 0; k < 4; k++) {
                            int yy = i + ty[k];
                            int xx = j + tx[k];

                            if(0<= yy && yy < y && 0 <= xx && xx < x) {
                                if(map[yy][xx] == 1) {
                                    flag = true;
                                    visited[yy][xx] = true;
                                }
                            }
                        }
                    }
                }
            }

            if(!flag) break;
            result_count = countdown(y,x,map, visited, count++);
            time++;
        }

        System.out.println(time);
        System.out.println(result_count);
    }

    private static void change(int[][] map, int count) {
        for(int i = 0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                if((map[i][j] == 0 || map[i][j] ==count-1) && (i==0 || i==y-1 || j == 0 || j == x-1)) {
                    check(map,i,j, count);
                }
            }
        }
    }

    private static void check(int[][] map, int i, int j, int count) {
        if(map[i][j] == count-1 || map[i][j] == 0) {
        map[i][j] = count;
        for(int k = 0; k < 4; k++) {
            int yy = i + ty[k];
            int xx = j + tx[k];

            if(0<= yy && yy < y && 0 <= xx && xx < x) {
                check(map, yy, xx, count);
            }
        }
        }
    }
    private static void firstCheck(int[][] map, int i, int j) {
        if(map[i][j] != 0) return;

        map[i][j] = 2;
        for(int k = 0; k < 4; k++) {
            int yy = i + ty[k];
            int xx = j + tx[k];

            if(0<= yy && yy < y && 0 <= xx && xx < x) {
                firstCheck(map, yy, xx);
            }
        }
    }

    private static int countdown(int y, int x, int[][] map, boolean[][] visited, int count) {



        int temp = 0;
        for(int i = 0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                if(map[i][j]==1) {
                    temp++;
                }
            }
        }
        for(int i = 0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                if(visited[i][j]) {
                    map[i][j] = count-1;
                }
            }
        }

        change(map, count);

        return temp;
    }
}