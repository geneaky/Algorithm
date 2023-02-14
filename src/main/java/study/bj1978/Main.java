package study.bj1978;

import java.util.*;
import java.io.*;

public class Main {

    static int N;

    static int[] input;

    static boolean[] map = new boolean[1001];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1978/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        input = new int[N];
        String[] s = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(s[i]);
        }

        map[0] = true;
        map[1] = true;
        for(int i = 2; i < 1001; i++) {
            if(!map[i]) {
                for(int j = i*2; j < 1001; j+=i) {
                    map[j] = true;
                }
            }
        }

        int result = 0;

        for(int i = 0; i < N; i++) {
            if(!map[input[i]]) {
                result++;
            }
        }

        System.out.println(result);
    }
}