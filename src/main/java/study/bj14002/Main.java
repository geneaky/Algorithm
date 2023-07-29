package study.bj14002;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj14002/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = 1;
        int ret = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = 1;
            for(int j = 1; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
            ret = Math.max(ret, dp[i]);
        }

        int value = ret;
        Stack<Integer> stack = new Stack<>();

        for(int i = n; i >= 1; i--){
            if(value == dp[i]) {
                stack.push(arr[i]);
                value--;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(ret);
        System.out.println(sb);
    }
}