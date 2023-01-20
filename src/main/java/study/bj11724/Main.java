package study.bj11724;

import java.util.*;
import java.io.*;

public class Main {

    static int N,M;

    static Node[] map;

    static boolean[] visited;

    static int result = 0;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj11724/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Node[N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < N+1; i++) {
            map[i] = new Node(i);
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start].children.add(map[end]);
            map[end].children.add(map[start]);
        }

        for(int i = 1; i < N+1; i++) {
            if(!visited[i] && map[i] != null) {
                dfs(i);
                result++;
            }
        }

        System.out.println(result);
    }

    private static void dfs(int nodeNumber) {
        if(visited[nodeNumber] || map[nodeNumber] == null) {
            return;
        }

        visited[nodeNumber] = true;

        Node node = map[nodeNumber];
        List<Node> children = node.children;
        for (Node child : children) {
//            System.out.println(child.number);
            dfs(child.number);
        }
    }

    public static class Node {

        int number;
        List<Node> children = new ArrayList<>();

        public Node(int number) {
            this.number = number;
        }
    }
}