package study.bj1182;

import java.util.*;
import java.io.*;

public class Main {

    static int N,S;

    static int[] arr;
    static int ret = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1182/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        if (S == 0) {
            System.out.println(ret -1);
        }else {
            System.out.println(ret);
        }
    }

    public static void dfs(int depth, int sum) {
        if(depth == N) {
            if(sum == S) {
                ret++;
            }
            return;
        }

        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum);
    }
}