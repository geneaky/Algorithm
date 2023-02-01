package study.bj1238;

import java.util.*;
import java.io.*;

public class Main {

    static int N,M,X;

    static List<List<Node>> goList = new ArrayList<>();
    static List<List<Node>> backList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1238/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            goList.add(new ArrayList<>());
            backList.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            goList.get(start-1).add(new Node(end-1, value));
            backList.get(end-1).add(new Node(start-1, value));
        }


        int[] dist1 = dijkstra(goList);
        int[] dist2 = dijkstra(backList);

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            max = Math.max(max, dist1[i]+dist2[i]);
        }

        System.out.println(max);
    }

    private static int[] dijkstra(List<List<Node>> adjList) {
        PriorityQueue<Node> pqueue = new PriorityQueue<>();

        boolean[] visited = new boolean[N];
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X-1] = 0;

        pqueue.offer(new Node(X-1, 0));

        while (!pqueue.isEmpty()) {
            Node temp = pqueue.poll();
            if(visited[temp.idx]) {
                continue;
            }

            visited[temp.idx] = true;
            for (Node node : adjList.get(temp.idx)) {
                if(!visited[node.idx] && dist[node.idx] > (dist[temp.idx] + node.value)) {
                    dist[node.idx] = dist[temp.idx] + node.value;
                    pqueue.offer(new Node(node.idx, dist[node.idx]));
                }
            }
        }

        return dist;
    }

    public static class Node implements Comparable<Node>{
        int idx;
        int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value, o.value);
        }
    }
}