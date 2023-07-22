package study.bj2294;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj2294/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        int[] dp = new int[K + 1];

        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= K; i++) {
            dp[i] = Integer.MAX_VALUE - 1 ;
        }

        for(int i = 1; i <= N; i++) {
            for(int j = arr[i]; j <= K; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }

        if(dp[K] == Integer.MAX_VALUE -1) {
            System.out.println(-1);
        }else{
            System.out.println(dp[K]);
        }
    }
}