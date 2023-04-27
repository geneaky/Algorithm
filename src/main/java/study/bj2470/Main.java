package study.bj2470;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj2470/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] numbers = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(numbers);

        long[] result = new long[2];
        result[0] = numbers[0];
        result[1] = numbers[N-1];

        int left = 0;
        int right = numbers.length-1;

        while(left < right) {
            long totalTemp = numbers[left] + numbers[right];
            long currentTotal = Math.abs(result[0] + result[1]);
            if(Math.abs(totalTemp) < currentTotal) {
                result[0] = numbers[left];
                result[1] = numbers[right];
                if(totalTemp == 0) {
                    break;
                }
            }

            if(totalTemp < 0) {
                left++;
            }else{
                right--;
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }
}