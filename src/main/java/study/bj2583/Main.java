package study.bj2583;

import java.util.*;
import java.io.*;

public class Main {

    static int M,N,K;

    static boolean[][] map;
    static int[] ty = {0,0, -1, 1};
    static int[] tx = {1, -1, 0,0};

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj2583/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];


        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());
            int end_x = Integer.parseInt(st.nextToken());
            int end_y = Integer.parseInt(st.nextToken());
            for(int j = N-end_y; j < N-start_y; j++) {
                for(int k = start_x; k < end_x; k++) {
                    map[j][k] = true;
                }
            }
        }

        int result = 0;
        for(int i = 0; i <N; i++) {
            for(int j = 0; j < M; j++) {
                if(!map[i][j]) {
                    list.add(dfs(i,j, 0));
                    result++;
                }
            }
        }

        System.out.println(result);
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(Integer l : list) {
            sb.append(l);
            sb.append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    private static int dfs(int i, int j, int cnt) {
        if(map[i][j]) {
            return cnt;
        }
        map[i][j] = true;
        cnt++;

        for(int k = 0; k < 4; k++) {
            int next_y = i + ty[k];
            int next_x = j + tx[k];

            if(next_y>=0&&next_y<N&&next_x>=0&&next_x<M) {
                cnt = Math.max(cnt,dfs(next_y,next_x, cnt));
            }
        }

        return cnt;
    }
}