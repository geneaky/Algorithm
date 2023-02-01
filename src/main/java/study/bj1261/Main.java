package study.bj1261;

import java.util.*;
import java.io.*;

public class Main {

    static int N,M;
    static int[][] map;
    static boolean[][] visited;

    static int[] ty = {0,0,1,-1};
    static int[] tx = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1261/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < M; i++) {
            String[] split = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        PriorityQueue<Node> pqueue = new PriorityQueue<>();
        pqueue.offer(new Node(0,0,map[0][0]));

        while(!pqueue.isEmpty()) {
            Node temp = pqueue.poll();
            if(visited[temp.start][temp.end]) {
                continue;
            }
            visited[temp.start][temp.end] = true;
            map[temp.start][temp.end] = temp.value;

            for(int i = 0; i < 4; i++) {
                int yy = temp.start + ty[i];
                int xx = temp.end + tx[i];
                if(0<=yy && yy<M && 0<=xx && xx<N) {
                    pqueue.offer(new Node(yy,xx, temp.value + map[yy][xx]));
                }
            }
        }

        System.out.println(map[M-1][N-1]);
    }

    public static class Node implements Comparable<Node> {

        int start;
        int end;
        int value;

        public Node(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }


        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value, o.value);
        }
    }
}