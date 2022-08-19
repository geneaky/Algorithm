package study.bj1920;

import java.util.*;
import java.io.*;

public class Main {

    // N x M으로 계산하면 시간초과 발생
    // nlogn, n, logn,1의 시간복잡도안에 해결해야 함
    // 이진탐색으로 풀자

    static int N,M;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1920/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        long[] Nlist = new long[N+1];
        Map<Long,Long> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i < N+1; i++) {
            long number = Long.parseLong(st.nextToken());
            map.put(number,number);
        }

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            long number = Long.parseLong(st.nextToken());

            if(map.containsKey(number)) {
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
}