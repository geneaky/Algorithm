package study.bj2178;

import java.util.*;
import java.io.*;
import org.w3c.dom.Node;

public class Main {

    static int N;
    static int M;

    static int[][] map;

    public static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(
            "/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj2178/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        Queue<Node> queue = new LinkedList<>();

        Node root = new Node(0, 0);

        queue.offer(root);

        while (!queue.isEmpty()) {

            for(int t = 0; t < queue.size(); t++) {
                Node temp = queue.poll();

                int y = temp.y;
                int x = temp.x;

                if (y == N - 1 && x == M - 1) {
                    break;
                }

                if (y - 1 >= 0 && map[y - 1][x] == 1) {
                    queue.offer(new Node(y - 1, x));
                    map[y-1][x] = map[y][x]+1;
                }

                if (y + 1 < N && map[y + 1][x] == 1) {
                    queue.offer(new Node(y + 1, x));
                    map[y+1][x] = map[y][x]+1;
                }

                if (x - 1 >= 0 && map[y][x - 1] == 1) {
                    queue.offer(new Node(y, x - 1));
                    map[y][x-1] = map[y][x]+1;
                }

                if (x + 1 < M && map[y][x + 1] == 1) {
                    queue.offer(new Node(y, x + 1));
                    map[y][x+1] = map[y][x]+1;
                }
            }
        }

        System.out.println(map[N-1][M-1]);
    }
}