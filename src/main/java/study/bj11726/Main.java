package study.bj11726;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj11726/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n+1];

        for(int i = 1; i <= n; i++) {
            if(i == 1) {
                numbers[1] = 1;
            }else if(i == 2) {
                numbers[2] = 2;
            }else {
                numbers[i] = (numbers[i-1] + numbers[i-2]) % 10_007;
            }
        }

        System.out.println(numbers[n]);
    }
}