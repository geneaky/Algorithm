package study.bj5052;

import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj5052/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- != 0) {
            int n = Integer.parseInt(br.readLine());
            String[] numbers = new String[n];
            for(int i = 0; i < n; i++) {
                numbers[i] = br.readLine();
            }

            Arrays.sort(numbers);

            boolean flag = false;

            for(int i = 0; i < n-1 ;i++) {
                if(numbers[i+1].startsWith(numbers[i])) {
                    flag = true;
                    break;
                }
            }

            if(flag) {
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");
        }

    }
}