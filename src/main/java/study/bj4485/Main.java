package study.bj4485;

import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;

    static int[] ty = {0,0,-1,1};
    static int[] tx = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj4485/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> result = new ArrayList<>();

        int count = 0;
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            count++;
            if(N == 0) {
                break;
            }
            map = new int[N][N];
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result.add("Problem "+count+": " + dijkstra());
        }

        for (String s : result) {
            System.out.println(s);
        }
    }

    private static int dijkstra() {

        PriorityQueue<Node> pqueue = new PriorityQueue<>();
        pqueue.offer(new Node(0,0, map[0][0]));

        while(!pqueue.isEmpty()) {
            Node temp = pqueue.poll();
            if(visited[temp.y][temp.x]) {
                continue;
            }

            visited[temp.y][temp.x] = true;
            map[temp.y][temp.x] = temp.value;

            for(int i = 0; i < 4; i++) {
                int yy = temp.y + ty[i];
                int xx = temp.x + tx[i];

                if(0<=yy&&yy<N&&0<=xx&&xx<N) {
                    pqueue.offer(new Node(yy,xx,temp.value+map[yy][xx]));
                }
            }
        }

        return map[N-1][N-1];
    }

    public static class Node implements Comparable<Node>{
        int y;
        int x;
        int value;

        public Node(int y, int x, int value) {
            this.y = y;
            this.x = x;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            if (this.value < o.value) {
                return -1;
            }
            return 1;
        }
    }
}