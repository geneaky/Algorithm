package study.bj2211;

import java.util.*;
import java.io.*;

public class Main {

    static int N,M;
    static int[][] map;
    static boolean[] visited;
    static int[] distance;
    static HashSet<String> resultSet;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj2211/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        visited = new boolean[N+1];
        distance = new int[N+1];
        resultSet = new HashSet<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            map[y][x] = value;
            map[x][y] = value;
        }

        dijkstra(1);

        System.out.println(resultSet.size());
        for (String s : resultSet) {
            System.out.println(s);
        }
    }

    private static void dijkstra(int start) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        int[] path = new int[N+1];
        PriorityQueue<Node> pqueue = new PriorityQueue<>();
        distance[start] = 0;
        pqueue.offer(new Node(start,distance[start]));

        while(!pqueue.isEmpty()) {
            Node temp = pqueue.poll();
            int newPoint = temp.y;
            visited[newPoint] = true;

            for(int i = 1; i <= N; i++) {
                if(map[newPoint][i] != 0) {
                    if(!visited[i] && (distance[i] > distance[newPoint] + map[newPoint][i])) {
                        distance[i] = distance[newPoint] + map[newPoint][i];
                        pqueue.offer(new Node(i,  distance[i]));
                        path[i] = newPoint;
                    }
                }
            }
        }

        for(int i = 2; i <= N; i++) {
            int end = i;
            while(path[end] != 0) {
                resultSet.add(end + " " + path[end]);
                end = path[end];
            }
        }
    }

    public static class Node implements Comparable<Node>{
        int y;
        int value;

        public Node(int y, int value) {
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(value, o.value);
        }
    }
}