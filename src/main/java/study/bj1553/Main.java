package study.bj1553;

import java.util.*;
import java.io.*;

public class Main {

    static int[][] board = new int[8][7];
    static boolean[][] visited = new boolean[8][7];
    static boolean[][] used = new boolean[7][7];

    static int[] ty = {0,1};
    static int[] tx = {1,0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1553/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int i = 0; i < 8; i++) {
            String[] split = br.readLine().split("");
            for(int j = 0; j < 7; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }

        System.out.println(backtrack(0,0));
    }

    private static int backtrack(int y, int x) {
        if(y==8) {
            return 1;
        }

        int count = 0;
        int nny = y;
        int nnx = x+1;

        if(nnx == 7) {
            nny++;
            nnx = 0;
        }

        if(visited[y][x]) {
            return backtrack(nny,nnx);
        }

        int now = board[y][x];
        visited[y][x] = true;

        for(int i = 0; i < 2; i++) {
            int ny = y + ty[i];
            int nx = x + tx[i];

            if(0<=ny && ny < 8 && 0<=nx && nx < 7) {
                int nxt = board[ny][nx];
                if(!used[nxt][now] && !visited[ny][nx]) {
                    used[now][nxt] = used[nxt][now] = true;
                    visited[ny][nx] = true;
                    count += backtrack(nny,nnx);
                    visited[ny][nx] = false;
                    used[now][nxt] = used[nxt][now] = false;
                }
            }
        }

        visited[y][x] = false;
        return count;
    }
}