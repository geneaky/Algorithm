package study.bj4963;

import java.util.*;
import java.io.*;

public class Main {

    static List<Integer> result = new ArrayList<>();

    static int W,H;

    static int[][] map;

    static boolean[][] visited;

    //8방
    static int[] ty = {0,0,1,-1,1,1,-1,-1};
    static int[] tx = {-1,1,0,0,-1,1,1,-1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj4963/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            if(W == 0 && H == 0) {
                break;
            }

            map = new int[H][W];
            visited = new boolean[H][W];

            for(int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int temp = 0;
            for(int i = 0; i < H; i++) {
                for(int j = 0; j < W; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        dfs(i,j);
                        temp++;
                    }
                }
            }

            result.add(temp);

        }

        for(Integer res : result) {
            System.out.println(res);
        }
    }

    private static void dfs(int i, int j) {
        if(visited[i][j] || map[i][j] != 1) {
            return;
        }

        visited[i][j] = true;

        for(int k = 0; k < 8; k++) {
            int next_y = i + ty[k];
            int next_x = j + tx[k];

            if(0<=next_y&&next_y<H&&0<=next_x&&next_x<W) {
                dfs(next_y, next_x);
            }
        }
    }
}