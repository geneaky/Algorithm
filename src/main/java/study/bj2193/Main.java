package study.bj2193;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj2193/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] numbers = new long[N+2];

        numbers[1] = 1;
        numbers[2] = 1;
        for(int i = 3; i <= N; i++) {
            numbers[i] = numbers[i-1] + numbers[i-2];
        }

        System.out.println(numbers[N]);
    }
}