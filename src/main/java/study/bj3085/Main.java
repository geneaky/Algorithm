package study.bj3085;

import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static String[][] map;
    static int result = 0;

    static int[] ty = {0,0,1,-1};
    static int[] tx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj3085/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new String[N][N];
        for(int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                map[i][j] = split[j];
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < 4; k++) {
                    int yy = i + ty[k];
                    int xx = j + tx[k];
                    if(0<= yy && yy < N && 0<= xx && xx < N) {
                        String temp = map[i][j];
                        map[i][j] = map[yy][xx];
                        map[yy][xx] = temp;
                        result = Math.max(backtrack(i,j), result);
                        temp = map[i][j];
                        map[i][j] = map[yy][xx];
                        map[yy][xx] = temp;
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static int backtrack(int y, int x) {
        int x_side = 0;
        for(int j = x; j < N; j++) {
            if(map[y][x].equals(map[y][j])) {
                x_side++;
            }else{
                break;
            }
        }

        for(int j = x; j >= 0; j--) {
            if(map[y][x].equals(map[y][j])) {
                x_side++;
            }else{
                break;
            }
        }
        x_side--;

        int y_side = 0;
        for(int i = y; i < N; i++) {
            if(map[y][x].equals(map[i][x])) {
                y_side++;
            }else{
                break;
            }
        }

        for(int i = y; i  >= 0; i--) {
            if (map[y][x].equals(map[i][x])) {
                y_side++;
            }else{
                break;
            }
        }
        y_side--;

        return Math.max(y_side, x_side);
    }
}