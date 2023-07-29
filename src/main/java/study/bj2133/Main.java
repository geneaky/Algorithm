package study.bj2133;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj2133/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] DP = new int[N + 1];

        if(N % 2 != 0) {
            System.out.println(0);
            return;
        }

        DP[0] = 1;
        DP[1] = 0;
        DP[2] = 3;
        for(int i = 4; i <= N; i++) {
            DP[i] = DP[i-2] * DP[2];
            for(int j = i - 4; j >= 0; j -= 2) {
                DP[i] = DP[i] + (DP[j] * 2);
            }
        }

        System.out.println(DP[N]);
    }
}