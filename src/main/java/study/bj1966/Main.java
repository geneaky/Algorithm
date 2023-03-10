package study.bj1966;

import java.util.*;
import java.io.*;

public class Main {

    public static class Node implements Comparable<Node>{
        int val;
        int idx;

        public Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.val, this.val);
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1966/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());

        while(count!=0) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            Queue<Node> queue = new LinkedList<>();
            PriorityQueue<Node> pqueue = new PriorityQueue<>();

            int result = 0;

            for(int i = 0; i < N; i++) {
                Node node = new Node(Integer.parseInt(st.nextToken()), i);
                queue.offer(node);
                pqueue.offer(node);
            }

            int index = 1;
            while(!pqueue.isEmpty()) {
                Node currentNode = pqueue.poll();
                while(true) {
                    Node temp = queue.poll();
                    if(temp.val == currentNode.val) {
                        if(temp.idx == M) {
                            result = index;
                        }
                        index++;
                        break;
                    }else{
                        queue.offer(temp);
                    }
                }
            }

            System.out.println(result);
            count--;
        }
    }
}