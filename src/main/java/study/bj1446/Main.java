package study.bj1446;

import java.util.*;
import java.io.*;

public class Main {

    static List<int[]>[] list;
    static int N,D,res;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1446/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        list = new ArrayList[10001];
        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        res = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list[start].add(new int[] {end, value});
        }

        int dp[] = new int[10001];
        init(dp);
        for(int i = 0; i <= D; i++) {
            if(i!=0) {
                dp[i] = Math.min(dp[i-1]+1, dp[i]);
            }

            if(list[i].size() > 0) {
                for(int tmp[] : list[i]) {
                    int val = tmp[1];
                    int end = tmp[0];
                    if(dp[end] > dp[i]+val) {
                        dp[end] = dp[i]+val;
                    }
                }
            }
        }

        System.out.println(dp[D]);
    }

    private static void init(int[] dp) {
        for(int i= 0; i < dp.length; i++) {
            dp[i] = i;
        }
    }
}