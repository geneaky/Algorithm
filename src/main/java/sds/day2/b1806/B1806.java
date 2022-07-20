package sds.day2.b1806;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1806 {

    static int N, S;

    static int[] nums;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/main/java/sds/day2/b1806/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0, high = 0, sum = nums[0], count = Integer.MAX_VALUE;

        while(true) {
            if(sum >= S) {
                count = Math.min(count, high - low + 1);
                sum -= nums[low++];
            }else{
                sum += nums[++high];
            }

            if(high == N){
                break;
            }
        }

        System.out.println(count);
    }

}
