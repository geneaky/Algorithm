package study.bj2331;

import java.util.*;
import java.io.*;

public class Main {

    static long A,P;

    static long numbers[] = new long[10];

    static int idx = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj2331/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        for(int i = 0; i < 10; i++) {
            numbers[i] = (long) Math.pow(i,P);
        }

        List<Long> result = new ArrayList<>();

        Long temp = A;

        while(true) {
            if(result.contains(temp)) {
                for(int i = 0; i < result.size(); i++) {
                    if(result.get(i).equals(temp)) {
                        idx = i;
                    }
                }
                break;
            }
            result.add(temp);
            char[] chars = temp.toString().toCharArray();
            temp = 0L;
            for (char a : chars) {
                temp += numbers[a - '0'];
            }
        }

        System.out.println(idx);
    }
}