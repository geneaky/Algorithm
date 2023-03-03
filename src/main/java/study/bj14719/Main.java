package study.bj14719;

import java.util.*;
import java.io.*;

public class Main {

    static int h,w;

    static int[] height;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj14719/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        height = new int[w];
        for(int i = 0; i < w; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int ret = 0;

        for(int i = 1; i < w-1; i++) {
            int left = 0;
            int right = 0;

            for(int j = 0; j < i; j++) {
                left = Math.max(height[j], left);
            }

            for(int j = i + 1; j < w; j++) {
                right = Math.max(height[j], right);
            }

            if(height[i] < left && height[i] < right) {
                ret += Math.min(right, left) - height[i];
            }
        }

        System.out.println(ret);
    }
}