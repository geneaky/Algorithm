package study.bj14938;

import java.util.*;
import java.io.*;

public class Main {

    static int n,m,r;

    static int[] subMap; //각 노드 별 아이템 개수

    static List<List<Node>> map = new ArrayList<>();

    public static class Node implements Comparable<Node>{
        int cur;
        int end;
        int value;

        public Node(int end, int value) {
            this.end = end;
            this.value = value;
        }

        public Node(int cur, int end, int value) {
            this.cur = cur;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.cur, this.cur);
        }
    }


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj14938/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        subMap = new int[n];
        String[] s = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
            subMap[i] = Integer.parseInt(s[i]);
        }


        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int value = Integer.parseInt(st.nextToken()); //이동비용

            map.get(start).add(new Node(end, value));
            map.get(end).add(new Node(start, value));
        }

        int[] dist = new int[n];
        for(int i = 0; i < n; i++) {
            dist[i] = dijkstra(i);
        }

        Arrays.sort(dist);
        System.out.println(dist[dist.length-1]);
    }

    private static int dijkstra(int i) {
        int[] d = new int[n];
        boolean[] v = new boolean[n];
        d[i] = subMap[i];
        PriorityQueue<Node> pqueue = new PriorityQueue<>();
        pqueue.offer(new Node(m, i, subMap[i]));

        while(!pqueue.isEmpty()) {
            Node temp = pqueue.poll();

            if(v[temp.end] || temp.cur < 0) continue;

            v[temp.end] = true;
            d[temp.end] = subMap[temp.end]; //갈 수 있으면 값 넣기

            for(Node node : map.get(temp.end)) {
                if(!v[node.end]) {
                    pqueue.offer(new Node(temp.cur-node.value, node.end, subMap[node.end]));
                }
            }
        }

        int result = 0;
        for(int a : d) {
            result += a;
        }

        return result;
    }
}