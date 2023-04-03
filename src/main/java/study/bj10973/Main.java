package study.bj10973;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj10973/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(prePermu(arr)) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
        }else{
            System.out.println(-1);
        }
    }

    private static boolean prePermu(int[] arr) {
        int i = arr.length -1;

        while(i > 0 && arr[i] > arr[i-1]) {
            i--;
        }

        if(i==0) return false;

        int j = arr.length -1;

        while(arr[i-1] < arr[j]) {
            j--;
        }

        swap(arr,i-1,j);

        j = arr.length -1;
        while(i<j) {
            swap(arr, i, j);
            i++;
            j--;
        }

        return true;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}