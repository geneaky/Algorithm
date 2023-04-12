package study.bj16234;

import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int L;
    static int R;
    static int[][] map;
    static boolean[][] visited;

    static int[] ty = {0, 0, 1, -1};
    static int[] tx = {1, -1, 0, 0,};

    static int result = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj16234/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<List<Node>> list;
        while(true) {
            visited = new boolean[N][N];
            list = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        List<Node> temp = new ArrayList<>();
//                        temp.add(new Node(i, j, map[i][j]));
                        dfs(i, j, temp);
                        if(temp.size() > 1) {
                            list.add(temp);
                        }
                    }
                }
            }

            if(list.size() == 0) {
                break;
            }

            result++;
            control(list);
        }

        System.out.println(result);
    }

    private static void control(List<List<Node>> list) {
        for (List<Node> nodes : list) {
            int total = 0;
            for (Node node : nodes) {
                total += node.population;
            }
            for (Node node : nodes) {
                map[node.y][node.x] = total / nodes.size();
            }
        }
    }

    private static void dfs(int y, int x, List<Node> temp) {
        if(visited[y][x]) return;
        visited[y][x] = true;
        temp.add(new Node(y, x, map[y][x]));

        for(int k = 0; k < 4; k++) {
            int yy = y + ty[k];
            int xx = x + tx[k];
            if(0 <= yy && yy < N && 0 <= xx && xx < N && !visited[yy][xx] && L <=Math.abs(map[yy][xx] - map[y][x]) && Math.abs(map[yy][xx] - map[y][x]) <= R ) {
                dfs(yy, xx, temp);
            }
        }
    }

    public static class Node {
        int y;
        int x;
        int population;

        public Node(int y, int x, int population) {
            this.y = y;
            this.x = x;
            this.population = population;
        }
    }
}