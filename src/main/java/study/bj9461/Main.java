package study.bj9461;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj9461/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        while(count-- != 0) {
            int N = Integer.parseInt(br.readLine());

            if(N == 1 || N == 2 || N == 3) {
                System.out.println(1);
            }else{
                long[] arr = new long[N+1];
                arr[1] = 1;
                arr[2] = 1;
                arr[3] = 1;
                for(int i = 4; i < N + 1; i++) {
                    arr[i] = arr[i-2] + arr[i-3];
                }

                System.out.println(arr[N]);
            }
        }
    }
}