package study.bj1010;

import java.util.*;
import java.io.*;

public class Main {

    static int T;

    static int[] M;
    static int[] N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1010/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            N = new int[n+1];
            M = new int[m+1];


            for(int i = 1; i < m+1; i++) {
                M[i] = 1;
            }

            for(int i = 1; i < n+1; i++) {
                M[i] = 0;
            }

            for(int i = 1; i < m-n+1; i++) {
                if(M[i] == 0) {
                    M[i] = -1;
                }else {
                    M[i] = 0;
                }
            }

            long temp = 1;
            for(int i = m; i >= 1; i--) {
                if(M[i] == 1) {
                    temp *= i;
                }else if(M[i] == -1) {
                    temp /= i;
                }
            }

            System.out.println(temp);
        }


    }

    private static long  factorial(int number) {
        long result = number;
        while(--number >= 1) {
            result *= number;
        }

        if(result == 0) {
            return 1;
        }else{
            return result;
        }
    }
}