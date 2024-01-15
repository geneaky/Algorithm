package study.bj5597;

import java.util.*;
import java.io.*;

public class Main {

    static boolean[] student = new boolean[31];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj5597/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 28; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            student[Integer.parseInt(st.nextToken())] = true;
        }

        for(int i = 1; i < 31; i++) {
            if (!student[i]) {
                System.out.println(i);
            }
        }
    }
}