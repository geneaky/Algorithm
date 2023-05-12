package study.bj9095;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj9095/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while(n-- != 0) {
            int t = Integer.parseInt(br.readLine());
            int[] numbers = new int[t+1];
            for(int i = 1; i <= t; i++) {
                if(i == 1) {
                    numbers[1] = 1;
                }else if(i == 2) {
                    numbers[2] = 2;
                }else if(i ==3) {
                    numbers[3] = 4;
                }else {
                    numbers[i] = numbers[i-1] + numbers[i-2] + numbers[i-3];
                }
            }

            System.out.println(numbers[t]);
        }

    }
}