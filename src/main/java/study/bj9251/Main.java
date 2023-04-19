package study.bj9251;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj9251/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        String[] AStr = A.split("");
        String[] BStr = B.split("");

        int ylen = A.length();
        int xlen = B.length();

        int[][] map = new int[ylen+1][xlen+1];

        for(int i = 1; i < ylen+1; i++) {
            for(int j = 1; j < xlen+1; j++) {
                if(AStr[i-1].equals(BStr[j-1])) {
                    map[i][j] = map[i-1][j-1] + 1;
                }else{
                    map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
                }
            }
        }

        System.out.println(map[ylen][xlen]);
    }
}