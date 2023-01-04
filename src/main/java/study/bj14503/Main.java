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

    private static void dfs(int y, int x, int d) {
        switch(map[y][x]) {
            case 1: return;
            case 0:
                map[y][x] = -1;
                result++;
        }

        for(int i = 0; i < 4; i++) {
            d = (d+3) % 4;
            int ny = y + ty[d];
            int nx = x + tx[d];

            if(map[ny][nx] == 0) {
                dfs(ny,nx,d);
                return;
            }
        }
        dfs(y-ty[d], x-tx[d], d);
        return;
    }
}