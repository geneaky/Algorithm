package sds.day6.b11438;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M;

    static int[] depth;
    static int[][] dp;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/main/java/sds/day6/b11438/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N 초기화 (2 ≤ N ≤ 100,000)
        N = Integer.parseInt(br.readLine());
        dp = new int[18][N+1]; // 2^k이 100,000까지 갈 수 있어야 하므로
        depth = new int[N+1];
        boolean[] visited = new boolean[N+1];

        ArrayList<Integer>[] adj = new ArrayList[N+1];

        for(int i = 1; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st;
        int a,b;
        //N번 정점 연결 입력
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for(int i = 0; i < adj[curr].size(); i++) {
                int next = adj[curr].get(i);
                if(visited[next]) {
                    continue;
                }
                dp[0][next] = curr;
                visited[next] = true;
                depth[next] = depth[curr] + 1;
                q.add(next);
            }
        }

        for(int i = 1; i < 18; i++) {
            for(int j = 1; j < N+1; j++) {
                dp[i][j] = dp[i-1][dp[i-1][j]];
            }
        }

        //M 초기화 (1 ≤ M ≤ 100,000)
        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sb.append(lca(a,b) + "\n");
        }

        System.out.println(sb);
    }

    static int lca(int a, int b) {
        if(depth[a] > depth[b]) {
            int tmp = b;
            b = a;
            a = tmp;
        }

        int gap = depth[b] - depth[a];

        for(int i = 0; i < 18; i++) {
            if((gap & (1 << i)) > 0) {
                b = dp[i][b];
            }
        }

        if(a == b) {
            return a;
        }

        for(int i = 17; i >= 0; i--) {
            if(dp[i][a] != dp[i][b]) {
                a = dp[i][a];
                b = dp[i][b];
            }
        }

        return dp[0][a];
    }

}
