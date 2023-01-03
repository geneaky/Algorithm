package study.bj14503;

import java.util.*;
import java.io.*;

public class Main {

    static int N, M;

    static int y, x;

    static int d;

    static int[][] map;

    static int result = 0;

    static int[] ty = {-1, 0, 1, 0};
    static int[] tx = {0, 1, 0, -1};
    //북 동 남 서

    //북 시작 북 서 남

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj14503/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(y, x, d);

        System.out.println(result);
    }

    //갈수있는곳만 가는걸로하자
    private static void dfs(int y, int x, int d) {
        if(map[y][x] == 0) {
            result++;
            map[y][x] = -1;
        }

        boolean flag = false;
        int origin = d;

        for(int i = 0; i < 4; i++) {
            int next_d = (d+3) % 4;
            int next_y = y + ty[next_d];
            int next_x = x + tx[next_d];

            if(next_y > 0 && next_x > 0 && next_y < N && next_x < M) {
                if(map[next_y][next_x] == 0) {
                    dfs(next_y, next_x, next_d);
                    flag = true;
                    break;
                }
            }
            d = (d+3) % 4;
        }

        if (!flag) {
            int next_d = (origin + 2) % 4;
            int next_y = y + ty[next_d];
            int next_x = x + tx[next_d];

            if(next_y > 0 && next_x > 0 && next_y < N && next_x < M) {
                if(map[next_y][next_x] != 1) {
                    dfs(next_y, next_x, origin);
                }
            }
        }

    }
}