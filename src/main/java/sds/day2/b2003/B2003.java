package sds.day2.b2003;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B2003 {

    static int N;
    static int M;

    static int[] numbers;

    static int ret;

    static int sum;

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("src/main/java/sds/day2/b2003/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        numbers = new int[N];

        for(int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        if(N == 1 && numbers[0] == M) {
            System.out.println(1);
            return;
        }
        int L = 0;
        int H = 1;

        ret = 0;
        sum = numbers[L] + numbers[H];

        while( H < numbers.length - 1) {
                if(sum < M) {
                    H++;
                    sum += numbers[H];
                }else if(sum > M) {
                    sum -= numbers[L];
                    L++;
                }else {
                    ret++;
                    sum -= numbers[L];
                    L++;
                }
        }

        if(sum == M) {
            ret++;
        }

        System.out.println(ret);

    }

}
