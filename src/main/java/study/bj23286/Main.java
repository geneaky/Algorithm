package study.bj23286;

import java.util.*;
import java.io.*;

public class Main {

    static int N, M, T;
    static Node graph[];
    static int[][] minHeight;
    static int[][] route;
    static StringTokenizer st;

    static class Node implements Comparable<Node> {
        int v;
        int h;
        Node link;

        public Node(int v, int h, Node link) {
            super();
            this.v = v;
            this.h = h;
            this.link = link;
        }

        @Override
        public int compareTo(Node o) {
            return this.h - o.h;
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj23286/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        graph = new Node[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            graph[u] = new Node(v, h, graph[u]);
        }
        // 입력 끝


        dijkstra();    // 다익스트라 수행 ( 플로이드 워셜로 대체 가능할 듯. )

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int result = findMin(start,end);    // 경로를 추적해서 최댓값을 가져옴.
            if(result == 100000000) result = -1;
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }



    static void dijkstra() {
        minHeight = new int[N + 1][N + 1];
        route = new int[N + 1][N + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {    // 모든 정점을 출발지로하여 다익스트라 수행.
            pq.clear();
            Arrays.fill(minHeight[i], 100000000);
            boolean[] visited = new boolean[N + 1];
            // 필요한 변수 초기화

            pq.offer(new Node(i, 0, graph[i]));
            minHeight[i][i] = 0;
            route[i][i] = 0;

            while (!pq.isEmpty()) {
                Node curr = pq.poll();

                if(visited[curr.v]) continue;
                visited[curr.v] = true;

                for (Node temp = graph[curr.v]; temp != null; temp = temp.link) {
                    if (!visited[temp.v] && minHeight[i][temp.v] > temp.h) {
                        pq.offer(new Node(temp.v, temp.h, null));
                        // 방문할 때 그 정점과 연결된 최소크기로 저장
                        minHeight[i][temp.v]
                            = Math.min(minHeight[i][temp.v], temp.h);
                        route[i][temp.v] = curr.v;
                    }
                }
            }
        }
    }

    static int findMin(int start, int end) {
        int res = 0;
        for (int i = 1; i <= N; i++) {
            while (end != 0) {
                res = Math.max(res, minHeight[start][end]);
                end = route[start][end];
            }
        }
        return res;
    }
}