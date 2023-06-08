package study.bj1309;

import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1309/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][3];

        Arrays.fill(arr[1], 1);

        for(int i = 2; i < N+1; i++) {
            arr[i][0] = arr[i-1][0] + arr[i-1][1] + arr[i-1][2];
            arr[i][1] = arr[i - 1][2] + arr[i - 1][0];
            arr[i][2] = arr[i - 1][1] + arr[i - 1][0];
            arr[i][0] %= 9901;
            arr[i][1] %= 9901;
            arr[i][2] %= 9901;
        }

        int rest = 0;

        for(int i = 0; i < 3; i++) {
            rest += arr[N][i];
        }

        System.out.println(rest%9901);
    }
}