package study.bj16918;

import java.util.*;
import java.io.*;

public class Main {

    static int R, C, N;
    static int map[][];

    static int[] ty = {0,0,1,-1};
    static int[] tx={1,-1,0,0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj16918/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for(int i = 0; i < R; i++) {
            String[] dots = br.readLine().split("");
            for(int j = 0; j < C; j++) {
                if(dots.equals("0")) {
                    map[i][j] = 2;
                }else{
                    map[i][j] = 0;
                }
            }
        }

        int time = 1;
        int current = 2;
        int bomb = 2;
        while(time != N) {
            time++;
            if(current == 2) {
                for(int i = 0; i < R; i++) {
                    for(int j = 0; j < C; j++) {
                        if(map[i][j] != bomb) {
                            map[i][j] = bomb+1;
                        }
                    }
                }

                current=3;
                continue;
            }

            if(current == 3) {
                for(int i = 0; i < R; i++) {
                    for(int j = 0; j < C; j++) {
                        if(map[i][j] == bomb) {
                            for(int k = 0; k <4;k ++) {
                                int yy = i + ty[k];
                                int xx = j + tx[k];
                                if(0<= yy && yy < R && 0 <= xx && xx < C) {
                                    map[yy][xx] = 0;
                                }
                            }
                            map[i][j] = 0;
                        }
                    }
                }
                current = 2;
            }
            bomb++;
        }


        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}