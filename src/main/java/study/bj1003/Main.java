package study.bj1003;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1003/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        while(count-- != 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n+1][2];

            if(n == 0) {
                System.out.println("1 0");
            }else if(n == 1) {
                System.out.println("0 1");
            }else{
                arr[0][0] = 1;
                arr[0][1] = 0;
                arr[1][0] = 0;
                arr[1][1] = 1;
                for(int i = 2; i < n+1; i++) {
                    arr[i][0] = arr[i-1][0] + arr[i-2][0];
                    arr[i][1] = arr[i-1][1] + arr[i-2][1];
                }
                System.out.println(arr[n][0] + " " + arr[n][1]);
            }
        }
    }
}