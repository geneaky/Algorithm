package sds.day4.b14476;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static long[] nums;

    static long[] LR;
    static long[] RL;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/main/java/sds/day4/b14476/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        nums = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        LR = new long[N];
        RL = new long[N];

        LR[0] = nums[0];
        RL[N-1] = nums[N-1];
        for(int i = 1; i < N; i++) {
            //LR gcd 배열을 만든다.
            LR[i] = gcd(LR[i-1], nums[i]);
            //RL gcd 배열을 만든다.
            RL[i] = gcd(RL[N -i-1], nums[i]);
        }

        List<long[]> list = new ArrayList<>();
        //두 배열을 반복문을 돌면서 index 하나씩 소거 후 GCD를 구한다.
        for(int i = 1; i < N; i++) {
            long k = nums[i];
            long gcd = gcd(LR[i - 1], RL[N - i]);
            //구한 gcd가 제외한 index의 숫자의 약수가 아니라면 list에 담는다.
            if(k % gcd != 0) {
                list.add(new long[]{gcd, k});
            }
        }

        Collections.sort(list,((o1, o2) -> (int) (o2[0] - o1[0])));

        if(list.size() != 0){
            System.out.println(list.get(0)[1] + " " + list.get(0)[0]);
        }else{
            System.out.println(-1);
        }
    }

    private static long gcd(long a, long b) {

        long temp;
        while(b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
