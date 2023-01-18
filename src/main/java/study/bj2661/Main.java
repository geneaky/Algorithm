package study.bj2661;

import java.util.*;
import java.io.*;

public class Main {

    static int start = 1;
    static int end = 3;
    static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj2661/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        backtracking("");
    }

    private static void backtracking(String s) {
        if(s.length() == N) {
            System.out.println(s);
            System.exit(0);
        }

        for(int i = start; i <= end; i++) {
            if(make(s+i)) {
                backtracking(s+i);
            }
        }
    }

    private static boolean make(String s) {
        for(int i = 1; i <= s.length()/2; i++) {
            String front = s.substring(s.length() - i * 2, s.length() -i );
            String back = s.substring(s.length() - i, s.length());
            if(front.equals(back)) {
                return false;
            }
        }
        return true;
    }
}