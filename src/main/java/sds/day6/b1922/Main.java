package sds.day6.b1922;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    static int[] parent;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/main/java/sds/day6/b1922/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        int[][] nodes = new int[M+1][3];

        parent = new int[N+1]; // 3번노드가 4번 노드를 루트로 가진다면 ? [x,x,4,x,x,x,...M+1];

        //루트를 나타내는 배열도 초기화
        for(int i = 1; i < N+1; i++) {
            parent[i] = i;
        }

        for(int i = 1; i < M+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nodes[i][0] = Integer.parseInt(st.nextToken());
            nodes[i][1] = Integer.parseInt(st.nextToken());
            nodes[i][2] = Integer.parseInt(st.nextToken());
        }


        //배열을 간선의 가중치로 정렬 해줌
        Arrays.sort(nodes, Comparator.comparingInt(o -> o[2]));

        int ret = 0;
        //노드와 노드를 연결 시작
        for(int i = 1; i < M+1; i++) {
            //연결 전 각 노드의 루트를 확인
            int x= find(nodes[i][0]);
            int y= find(nodes[i][1]);

            if(x != y){
                // 각 노드의 루트가 다르다면
                //연결
                union(x,y);
                // 가중치를 추가
                ret += nodes[i][2];
            }
        }

        System.out.println(ret);

    }

    private static int find(int node) {
        return parent[node] = (node == parent[node]) ? node : find(parent[node]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        parent[x] = y;
    }
}
