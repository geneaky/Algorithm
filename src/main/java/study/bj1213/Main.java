package study.bj1213;

import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1213/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        int[] alpha = new int[26];

        for(int i = 0; i < line.length(); i++) {
            int idx = line.charAt(i) - 'A';
            alpha[idx]++;
        }

        int isOne = 0;
        for(int i = 0; i < alpha.length; i++) {
            if(alpha[i]%2!=0) isOne++;
        }

        String answer = "";
        StringBuilder sb = new StringBuilder();
        if(isOne > 1) {
            answer += "I'm Sorry Hansoo";
        }else{
            for(int i = 0; i < alpha.length; i++) {
                for(int j = 0; j < alpha[i]/2; j++) {
                    sb.append((char)(i+65));
                }
            }
            answer += sb.toString();
            String end = sb.reverse().toString();

            sb = new StringBuilder();
            for(int i = 0; i < alpha.length; i++) {
                if(alpha[i]%2==1) {
                    sb.append((char) (i + 65));
                }
            }

            answer += sb.toString() + end;
        }

        System.out.println(answer);
    }
}