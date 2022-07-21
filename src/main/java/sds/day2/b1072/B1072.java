package sds.day2.b1072;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1072 {

    static long X, Y;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/main/java/sds/day2/b1072/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());

        long Z = 100 * Y / X;

        long low = 0, high = X, mid, ret = 0;

        while(true) {
            mid = (low + high) / 2;

            if( (100 * (Y+mid) / (X+mid)) > Z) {
                ret = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }

            if(low > high) {
                break;
            }
        }

        if(ret == 0) {
            System.out.println(-1);
        }else{
            System.out.println(ret);
        }
    }

}
