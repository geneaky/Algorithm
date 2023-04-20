package study.bj5582;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj5582/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        String[] Arr = A.split("");
        String[] Brr = B.split("");

        int ylen = A.length();
        int xlen = B.length();

        int[][] map = new int[ylen+1][xlen+1];

        int result = 0;
        for(int i = 1; i < ylen+1; i++) {
            for(int j = 1; j < xlen+1; j++) {
                if(Arr[i-1].equals(Brr[j-1])) {
                    map[i][j] = map[i-1][j-1] + 1;
                    result = Math.max(result, map[i][j]);
                }else{
                    map[i][j] = 0;
                }
            }
        }

        System.out.println(result);
    }
}