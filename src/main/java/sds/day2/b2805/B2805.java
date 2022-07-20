package sds.day2.b2805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2805 {

    static int N, M;

    static int[] trees;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/main/java/sds/day2/b2805/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new int[N];

        st = new StringTokenizer(br.readLine());

        int start = 0, mid = 0, end = 0, ret = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, trees[i]);
        }


        while(start <= end) {
            mid = (start + end) / 2;

            int length = calc(mid);

            if(length > M) {
                start = mid + 1;
                ret = Math.min(ret, mid);
            }else if (length == M) {
                ret = mid;
                break;
            }else {
                end = mid - 1;
            }

        }

        System.out.println(ret);
    }

    public static int calc(int mid) {
        int temp = 0;
        for(int i = 0; i < trees.length; i++) {
            if(trees[i] > mid){
                temp += trees[i] - mid;
            }
        }

        return temp;
    }

}
