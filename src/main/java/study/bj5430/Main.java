package study.bj5430;

import java.util.*;
import java.io.*;

public class Main {

    static int T;
    static String[] p;
    static int n;
    static int[] arr;

    static int left;
    static int right;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj5430/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while(T-- != 0) {
            p = br.readLine().split("");
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            Deque<Integer> deque = new ArrayDeque<>();

            String[] split = br.readLine().replaceAll("\\[", "").replaceAll("\\]", "")
                .replaceAll(",", "").split("");

            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(split[i]);
                deque.add(Integer.parseInt(split[i]));
            }

            left = 0;
            right = n > 0 ? n-1 : 0;

            int delete_count = 0;
            int reverse_count = 0;

            for(int i = 0; i < p.length; i++) {
                if(p[i].equals("R")) {
                    reverse_count++;
                }else{
                    delete_count++;
                    if(deque.isEmpty()) {
                        System.out.println("error");
                        break;
                    }
                    if(reverse_count % 2 == 0) {
                        deque.removeFirst();
                    }else{
                        deque.removeLast();
                    }
                }
            }

            if (delete_count >= n) {
                continue;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while(!deque.isEmpty()) {
                if(reverse_count % 2 ==0) {
                    sb.append(deque.removeFirst());
                }else{
                    sb.append(deque.removeLast());
                }
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("]");
            System.out.println(sb);
        }
    }
}