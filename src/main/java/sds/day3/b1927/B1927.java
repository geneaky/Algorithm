package sds.day3.b1927;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class B1927 {

    static int N;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/main/java/sds/day3/b1927/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int temp = Integer.parseInt(st.nextToken());

            if(temp == 0) {
                if(list.size() == 0) {
                    System.out.println(0);
                }else{
                    System.out.println(list.remove(0));
                }
            }else{
                list.add(temp);
                Collections.sort(list);
            }
        }

    }

}
