package sds.day7.b2458;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N,M;

    static int[] inCnt, outCnt;

    static boolean[] visited;

    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/sds/day7/b2458/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        inCnt = new int[N+1];

        for(int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
        }

        outCnt = new int[N+1];
        for(int i = 1; i < N+1; i++) {
            visited = new boolean[N+1];
            outCnt[i] = dfs(i) - 1;
        }

        int answer = 0;
        for(int i = 1; i < N+1; i++) {
            if ((inCnt[i] + outCnt[i]) == N - 1) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static int dfs(int curr) {
        int outCnt = 0;
        for(int next : adj[curr]) {
            if(visited[next]) {
                continue;
            }
            inCnt[next]++;
            visited[next] = true;
            outCnt += dfs(next);
        }
        return outCnt;
    }

}
