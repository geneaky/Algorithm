package study.bj2839;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj2839/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sugar = Integer.parseInt(br.readLine());

        int result = 0;

        while(sugar > 0) {
            if(sugar % 5 == 0) {
                result += sugar/5;
                sugar %= 5;
            }else{
                result++;
                sugar -= 3;
            }
        }

        if(sugar != 0) {
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }
}