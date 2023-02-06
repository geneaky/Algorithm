package study.bj1719;

import java.util.*;
import java.io.*;

public class Main {

    static int N, M;

    static List<List<Node>> list;
    static int[] path, dist;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1719/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int value = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, value));
            list.get(end).add(new Node(start, value));
        }

        for(int i =0; i < N; i++) {
            path = new int[N];
            dist = new int[N];
            visited = new boolean[N];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dijkstra(i);
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pqueue = new PriorityQueue<>();
        pqueue.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pqueue.isEmpty()) {
            Node cur = pqueue.poll();
            if(visited[cur.target]) continue;
            visited[cur.target] = true;

            for(Node node : list.get(cur.target)) {
                if(visited[node.target]) continue;

                if(dist[node.target] > dist[cur.target] + node.value) {
                    path[node.target] = cur.target;
                    dist[node.target] = dist[cur.target] + node.value;
                    pqueue.add(new Node(node.target, dist[node.target]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            if(i == start) sb.append("-").append(" ");
            else sb.append(find(i, start)).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static int find(int x, int start) {
        if(path[x] == start) return x+1;
        return find(path[x], start);
    }

    public static class Node implements Comparable<Node> {

        int target;
        int value;

        public Node(int target, int value) {
            this.target = target;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value, o.value);
        }
    }
}