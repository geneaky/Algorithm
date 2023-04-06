package study.bj2573;

import java.util.*;
import java.io.*;

public class Main {

    static int y,x;

    static int[][] map;

    static int[] ty = {0, 0, 1, -1};
    static int[] tx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj2573/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        map = new int[y][x];

        for(int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < x; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int land = findLand();

        int result = 0;
        while(land == 1) {

            boolean[][] visited = new boolean[y][x];

            for(int i = 0; i < y; i++) {
                for(int j = 0; j < x; j++) {
                    if(map[i][j] != 0) {
                        for(int k = 0; k < 4; k++) {
                            int yy = i + ty[k];
                            int xx = j + tx[k];

                            if(0 <= yy && yy < y && 0 <= xx && xx < x) {
                                if(map[yy][xx] == 0 && map[i][j] != 0 && !visited[i][j] && !visited[yy][xx]) {
                                    map[i][j]--;
                                }
                            }
                        }

                        visited[i][j] = true;
                    }
                }
            }
            land = findLand();
            result++;
        }

        if(land == 0){
            System.out.println(0);
        }else{
            System.out.println(result);
        }
    }

    private static int findLand() {
        int count = 0;

        boolean[][] visited = new boolean[y][x];

        for(int i = 0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                if(map[i][j] != 0 && !visited[i][j]) {
                    count++;
                    dfs(visited,i,j);
                }
            }
        }

        return count;
    }

    private static void dfs(boolean[][] visited, int i, int j) {
        if(visited[i][j] || map[i][j] == 0) return;

        visited[i][j] = true;

        for(int k = 0; k < 4; k++) {
            int yy = i + ty[k];
            int xx = j + tx[k];

            if (0 <= yy && yy < y && 0 <= xx && xx < x) {
                dfs(visited,yy,xx);
            }
        }
    }
}