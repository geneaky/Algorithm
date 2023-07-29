package study.bj11054;

import java.util.*;
import java.io.*;

public class Main {


    static int N;
    static int[] seq;
    static int[] r_dp;
    static int[] l_dp;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj11054/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        seq = new int[N];
        r_dp = new int[N];
        l_dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        LIS();
        LDS();

        int max = 0;
        for(int i = 0; i < N; i++) {
            if (max < r_dp[i] + l_dp[i]) {
                max = r_dp[i] + l_dp[i];
            }
        }

        System.out.println(max -1 );
    }

    private static void LDS() {
        for(int i = N - 1; i >= 0; i--) {
            l_dp[i] = 1;
            for(int j = N - 1; j > i; j--) {
                if(seq[j] < seq[i] && l_dp[i] < l_dp[j] + 1) {
                    l_dp[i] = l_dp[j] + 1;
                }
            }
        }
    }

    private static void LIS() {

        for(int i = 0; i < N; i++) {
            r_dp[i] = 1;

            for(int j = 0; j < i; j++) {
                if(seq[j] < seq[i] && r_dp[i] < r_dp[j] + 1) {
                    r_dp[i] = r_dp[j] + 1;
                }
            }
        }
    }
}