package study.bj2667;

import java.util.*;
import java.io.*;

public class Main {

    static int N;

    static int[][] map;

    static int[] ty = {-1, 1, 0, 0};
    static int[] tx = {0, 0, -1, 1};

    static int count = 0;
    //상, 하, 좌, 우
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj2667/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        int result = 0;
        List<Integer> totalCounts = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1) {
                    count = 0;
                    dfs(i,j);
                    totalCounts.add(count++);
                    result++;
                }
            }
        }

        Collections.sort(totalCounts);
        System.out.println(result);
        for (Integer totalCount : totalCounts) {
            System.out.println(totalCount);
        }
    }

    private static void dfs(int i, int j) {
        if(map[i][j] != 1) {
            return;
        }
        map[i][j] = 0;
        count++;
        for(int k = 0; k < 4; k++) {
            int next_y = i + ty[k];
            int next_x = j + tx[k];
            if(0<= next_y && next_y < N && 0 <= next_x && next_x < N) {
                dfs(next_y, next_x);
            }
        }


    }
}