package study.bj1138;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1138/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] list = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> result= new ArrayList<>();

        for(int i = N; i >= 1; i--) {
            result.add(list[i], i);
        }

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }
}