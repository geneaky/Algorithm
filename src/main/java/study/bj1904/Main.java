package study.bj1904;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1904/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] result = new long[N+1];

        if(N==1) {
            System.out.println(1);
        }else if(N==2) {
            System.out.println(2);
        }else{
            result[1] = 1;
            result[2] = 2;

            for(int i = 3; i <= N; i++) {
                result[i] = (result[i-1] + result[i-2]) % 15746;
            }

            System.out.println(result[N]);
        }
    }
}