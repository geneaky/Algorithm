package study.bj14501;

import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj14501/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int[] DP = new int[N + 2];

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken()); // 상담일 수
            P[i] = Integer.parseInt(st.nextToken()); // 금액
        }


        for(int i = N; i > 0; i--) {
            int next = i + T[i];

            if(next > N + 1) {
                DP[i] = DP[i+1];
            }else{
                DP[i] = Math.max(DP[i + 1], P[i] + DP[next]);
            }
        }

        System.out.println(DP[1]);
    }
}