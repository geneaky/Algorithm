package study.bj1182;

import java.util.*;
import java.io.*;

public class Main {

    static int N,S;

    static int[] arr;
    static boolean[] visited;
    static int[] nArr;

    static int ret = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1182/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            nArr = new int[i];
            backtrack(0, 0, i);
        }

        System.out.println(ret);
    }

    public static void backtrack(int start, int depth, int limit) {
        if(depth == limit) {
            int sum = 0;
            for(int a : nArr) {
                sum += a;
            }

            if(sum == S) {
                ret++;
            }
            return;
        }

        for(int i = start; i <N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                nArr[depth] = arr[i];
                backtrack(i + 1, depth + 1, limit);
                visited[i] = false;
            }
        }
    }
}