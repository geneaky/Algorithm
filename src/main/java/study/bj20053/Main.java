package study.bj20053;

import java.util.*;
import java.io.*;

public class Main {

    static Integer N, T, value;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj20053/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

       N = Integer.parseInt(st.nextToken());
       for(int i = 0; i < N; i++) {
           st = new StringTokenizer(br.readLine());
           T = Integer.parseInt(st.nextToken());

           st = new StringTokenizer(br.readLine());
           int min = Integer.MAX_VALUE;
           int max = Integer.MIN_VALUE;
           for(int j = 0; j < T; j++) {
               value = Integer.parseInt(st.nextToken());
               min = Math.min(min, value);
               max = Math.max(max, value);
           }
           System.out.println(min + " " + max);
       }
    }
}