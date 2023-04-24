package study.bj14725;

import java.util.*;
import java.io.*;

public class Main {

    static class Node {

        String food;
        Node leftNode;
        Node rightNode;

        public Node() {
        }

        public Node(String food) {
            this.food = food;
        }

        public Node(String food, Node leftNode, Node rightNode) {
            this.food = food;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj14725/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Node rootNode = new Node("");
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int depth = Integer.parseInt(st.nextToken());
            Queue<String> queue = new LinkedList<>();
            for(int j = 0; j < depth; j++) {
                //탐색하며 넣기
                queue.offer(st.nextToken());
            }
            init(rootNode, queue);
        }

        //self left right
        dfs(rootNode, 0);
    }

    private static void dfs(Node node, int depth) {
        if(node == null) return;

        if(depth == 0) {
            dfs(node.leftNode, depth+1);
            dfs(node.rightNode, depth+1);
        }else{
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= depth && depth != 1; i++) {
                sb.append("-");
            }
            sb.append(node.food);
            System.out.println(sb.toString());
            dfs(node.leftNode, depth+1);
            dfs(node.rightNode, depth+1);
        }
    }

    private static void init(Node node, Queue<String> queue) {
        if(queue.isEmpty()) return;
        //같으면 통과 left right
        //다르면
            //left 없으면 left로
            //left 있으면 음식 비교후
                // 왼
                // 오

        String nextFood = queue.poll();
        if(node.food.equals("")) {
            if(node.leftNode == null) {
                node.leftNode = new Node(nextFood);
                init(node.leftNode, queue);
            }else{
                if(node.leftNode.food.equals(nextFood)) {
                    init(node.leftNode,queue);
                    init(node.rightNode,queue);
                }else if(node.leftNode.food.compareTo(nextFood) < 0) {
                    node.rightNode = new Node(nextFood);
                    init(node.rightNode, queue);
                }else{
                    swap(node, nextFood);
                    init(node.leftNode, queue);
                }
            }
        }else{
            if(node.food.equals(nextFood)) {
                init(node.leftNode, queue);
                init(node.rightNode, queue);
            }else if(node.leftNode == null) {
                node.leftNode = new Node(nextFood);
                init(node.leftNode, queue);
            } else if(node.food.compareTo(nextFood) < 0) {
                if(node.rightNode == null) {
                    node.rightNode = new Node(nextFood);
                }
                init(node.rightNode, queue);
            }else{
                if(node.leftNode == null) {
                    node.leftNode = new Node(nextFood);
                    init(node.leftNode, queue);
                }else{
                    if(node.leftNode.food.compareTo(nextFood) < 0) {
                        init(node.rightNode, queue);
                    }else {
                        swap(node.leftNode, nextFood);
                        init(node.leftNode, queue);
                    }

                }
            }
        }
    }

    private static void swap(Node node, String nextFood) {
        Node temp = node.leftNode;
        node.leftNode = new Node(nextFood);
        node.rightNode = temp;
    }
}
