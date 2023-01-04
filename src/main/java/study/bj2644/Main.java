package study.bj2644;

import java.util.*;
import java.io.*;

public class Main {

    static int totalNumber;

    static int a;
    static int b;

    static int m;

    static Node[] map;

    static int result = -1;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj2644/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        totalNumber = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());

        map = new Node[totalNumber+1];

        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            if(map[i1] == null) {
                map[i1] = new Node(i1);
            }
            if(map[i2] == null) {
                map[i2] = new Node(i2);
            }
            map[i2].parent = map[i1];
            if(!map[i1].childNodes.contains(map[i2])) {
                map[i1].childNodes.add(map[i2]);
            }
        }

        dfs(0, map[a]);

        System.out.println(result);
    }

    private static void dfs(int count, Node node) {
        if(node.flag) {
            return;
        }

        if(node.number == b) {
            result = count;
            return;
        }
        count++;
        node.flag = true;

        if(node.parent != null) {
            dfs(count, node.parent);
        }

        if(!node.childNodes.isEmpty()) {
            for(Node temp : node.childNodes) {
                dfs(count, temp);
            }
        }
    }

    public static class Node {
        Node parent;
        int number;
        boolean flag = false;
        List<Node> childNodes = new ArrayList<>();

        public Node(int number) {
            this.number = number;
        }
    }
}