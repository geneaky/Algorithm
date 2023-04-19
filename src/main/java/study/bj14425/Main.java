package study.bj14425;

import java.util.*;
import java.io.*;

public class Main {

    static int N,M;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj14425/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            String key = br.readLine();
            set.add(key);
        }

        int result = 0;
        for(int i = 0; i < M; i++) {
            if(set.contains(br.readLine())) {
                result++;
            }
        }

        System.out.println(result);
    }
}