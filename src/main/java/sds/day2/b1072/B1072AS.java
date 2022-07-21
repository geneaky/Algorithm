package sds.day2.b1072;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1072AS {

    static long X, Y;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/main/java/sds/day2/b1072/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());

        long Z = 100 * Y / X;

        if(Z >= 99) {
            System.out.println(-1);
        }else{
            long start = 0;
            long end = X;
            while(start < end) {
                long mid = (start + end) / 2;
                long newRate = (100 * (Y+mid) / (X+mid));
                if(newRate == Z) {
                    start = mid + 1;
                }else{
                    end = mid;
                }
            }

            System.out.println(end);
        }
    }

}
