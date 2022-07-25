package sds.day4.b14476;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class MainAS {

    static int N;

    static long[] nums;

    static long[] LR;
    static long[] RL;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/main/java/sds/day4/b14476/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        nums = new long[N];
        LR = new long[N];
        RL = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        //LtoR 만들기
        LR[0] = nums[0];
        for(int i = 1; i < N; i++) {
            LR[i] = gcd(LR[i-1], nums[i]);
        }

        //RtoL 만들기
        RL[N-1] = nums[N-1];
        for(int i = N - 2; i >= 0; i--){
            RL[i] = gcd(RL[i+1], nums[i]);
        }

        //k 선정하기
        long max = 0;
        int maxIndex = 0;
        for(int i = 0; i < N; i++) {
            long gcd = 0;
            //0
            if(i == 0) {
                gcd = RL[1];
            }
            //N-1
            else if(i == N - 1) {
                gcd = LR[N-2];
            }
            //중간은 LR , RL 사용
            else{
                gcd = gcd(LR[i - 1], RL[i+1]);
            }

            if(nums[i] % gcd != 0 && gcd > max) {
                max = gcd;
                maxIndex = i;
            }
        }



    }


    //gcd (a, b) == gcd(b, r) == gcd(b, a % b), stop when a % b == 0
    private static long gcd(long a, long b) {

        while(b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}
