package study.bj1926;

import java.util.*;
import java.io.*;

public class Main {

    private static int N,M;
    private static int[][] map;
    private static int[] ty = {0, 0, 1, -1};
    private static int[] tx =  {1, -1, 0, 0};
    private static int retCnt = 0;
    private static int retLength = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1926/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i< N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 1) {
                    retCnt++;
                    retLength = Math.max(retLength, dfs(i,j, 1));
                }
            }
        }

        System.out.println(retCnt);
        System.out.println(retLength);
    }

    private static int dfs(int x, int y, int length) {
        map[x][y] = 0;

        for(int i = 0; i < 4; i++) {
            int xx = x + tx[i];
            int yy = y + ty[i];
            if(0 <= xx && xx < N && 0 <= yy && yy < M) {
                if(map[xx][yy] == 1) {
                    length += dfs(xx,yy, 1);
                }
            }
        }

        return length;
    }
}