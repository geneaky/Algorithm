package study.bj2477;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj2477/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());


        int[] arr = new int[6];

        int maxWidth = 0;
        int maxWidthIdx = 0;
        int maxHeight = 0;
        int maxHeightIdx = 0;

        for(int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            arr[i] = Integer.parseInt(st.nextToken());

            if ((d == 1 || d == 2) && maxWidth < arr[i]) {
                maxWidth = arr[i];
                maxWidthIdx = i;
            }

            if((d==3||d==4) && maxHeight < arr[i]) {
                maxHeight = arr[i];
                maxHeightIdx = i;
            }
        }

        int right,left, minWidth, minHeight = 0;

        if(maxWidthIdx+1 == 6) right = 0;
        else right = maxWidthIdx+1;

        if(maxWidthIdx-1 ==-1) left = 5;
        else left = maxWidthIdx-1;

        minHeight = Math.abs(arr[right] - arr[left]);

        if(maxHeightIdx+1 ==6) right = 0;
        else right = maxHeightIdx+1;

        if(maxHeightIdx-1==-1)left = 5;
        else left = maxHeightIdx-1;

        minWidth = Math.abs(arr[right]-arr[left]);

        System.out.println(((maxWidth*maxHeight)-(minWidth*minHeight))*N);
    }
}