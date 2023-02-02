package study.bj5972;

import java.util.*;
import java.io.*;

public class Main {

    static int N,M;

    static List<List<Node>> map = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj5972/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            map.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int value = Integer.parseInt(st.nextToken());

            map.get(start).add(new Node(end, value));
            map.get(end).add(new Node(start, value));
        }

        int[] dist = new int[N];
        boolean[] v = new boolean[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Node> pqueue = new PriorityQueue<>();
        pqueue.offer(new Node(0, 0));
        while(!pqueue.isEmpty()) {
            Node temp = pqueue.poll();
            if(v[temp.target]) continue;
            v[temp.target] = true;
            for(Node node : map.get(temp.target)) {
                if(dist[node.target] > dist[temp.target] + node.value) {
                    dist[node.target] = dist[temp.target] + node.value;
                    pqueue.offer(new Node(node.target, dist[node.target]));
                }
            }
        }

        System.out.println(dist[N-1]);
    }

    public static class Node implements Comparable<Node>{
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