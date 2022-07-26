package sds.day6.b1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent, depth;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        depth = new int[N+1];

        for(int i = 1; i <= N; i++){
            parent[i] = i;
            depth[i] =  1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(command == 0) {
                //0일때는 집합 연산
                union(a,b);
            }else if(command == 1) {
                //1일때는 같은 집합인지 검색
                sb.append((find(a) == find(b) ? "YES" : "NO") + "\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    private static int find(int x) {
        //find연산 하면서 각 노드가 루트를 가리키도록 경로 압축
        return parent[x] = (x == parent[x]) ? x : find(parent[x]);
    }

    private static void union(int a, int b) {
        //루트를 찾아서
        int x = find(a);
        int y = find(b);
        //루트가 서로 다르면 (서로 다른 집합 이면)
        if(x != y) {
            //depth가 최소를 유지할 수 있도록
            if(depth[x]< depth[y]) {
                int temp = x;
                x = y;
                y = temp;
            }
            parent[y] = x;
            //2개의 depth가 같은 경우는 detph 하나 증가
            if(parent[x] == parent[y]) depth[x]++;
        }
    }

}
