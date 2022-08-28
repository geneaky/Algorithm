package study.bj1339;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    static int N;

    static int ret;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1339/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] list = new int[26];

        for(int i = 0; i < N; i++) {
            String temp = br.readLine();
            char[] c = temp.toCharArray();
            for(int j = 0; j < c.length; j++) {
                list[c[j] - 'A'] += (int)Math.pow(10, c.length-1-j);
            }
        }

        int[] result = Arrays.stream(list).boxed()
            .sorted(Collections.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

        int number = 9;
        for(int i = 0; i < result.length; i++) {
            ret += result[i] * number;
            number--;
        }

        System.out.println(ret);
    }
}