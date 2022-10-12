package study.bj1260;

import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int self;
        List<Node> adjList = new ArrayList();

        boolean dfs_flag = false;
        boolean bfs_flag = false;

        public Node(int self) {
            this.self = self;
        }
    }

    static int N;
    static int M;
    static int V;

    static String dfs = "";
    static String bfs = "";
    static Node[] list;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1260/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        list = new Node[N+1];

        for(int i = 1; i < N+1; i++) {
            list[i] = new Node(i);
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].adjList.add(list[y]);
            list[y].adjList.add(list[x]);
        }

        for(int i = 1; i < N+1; i++) {
            list[i].adjList.sort(Comparator.comparingInt(a -> a.self));
        }

        dfs(V);
        bfs(V);
        dfs.trim();
        bfs.trim();

        System.out.println(dfs);
        System.out.println(bfs);
    }

    private static void dfs(int V) {
        if(list[V].dfs_flag) return;
        list[V].dfs_flag = true;
        dfs += list[V].self + " ";
        for(int i = 0; i < list[V].adjList.size(); i++) {
            dfs(list[V].adjList.get(i).self);
        }
    }

    private static void bfs(int V) {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(list[V]);

        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            if(temp.bfs_flag) {
                continue;
            }

            temp.bfs_flag = true;
            bfs += temp.self + " ";
            for(int i = 0; i < temp.adjList.size(); i++) {
                queue.offer(temp.adjList.get(i));
            }
        }
    }
}