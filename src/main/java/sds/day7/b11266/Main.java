package sds.day7.b11266;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[] order;
    static boolean[] isCut;
    static int cnt;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/main/java/sds/day7/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        order = new int[N+1];
        isCut = new boolean[N+1];
        adj = new ArrayList[N+1];

        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i<= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b); //a노드에 b가 연결되어 있다.
            adj[b].add(a); //b노드에 a가 연결되어 있다.
        }

        for(int i = 1; i <= N; i++) {
            if(order[i] == 0) {
                dfs(i, true);
            }
        }
    }

    private static int dfs(int cur, boolean isRoot) {
        order[cur] = ++cnt;
        int ret = cnt;
        int child = 0;
        for(int next : adj[cur]) {
            if(order[next] == 0) {
                child++;
                int low = dfs(next, false);
                if (!isRoot && low >= order[cur]) {
                    isCut[cur] = true;
                }
                ret = Math.min(ret, low);
            } else {
                ret = Math.min(ret, order[next]);
            }
        }
        if(isRoot && child > 1) {
            isCut[cur] = true;
        }
        return ret;
    }

}
