package sds.day2.b2143;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B2143AS {

    static int T, N , M;

    static long[] A;
    static long[] B;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/main/java/sds/day2/b2143/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new long[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        B = new long[M];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        List<Long> subA = new ArrayList<>();
        List<Long> subB = new ArrayList<>();

        //subA구하기
        for(int i = 0; i < N; i++) {
            long sum = A[i];
            subA.add(sum);
            for(int j = i + 1; j < N; j++) {
                sum += A[j];
                subA.add(sum);
            }
        }
        //subB구하기
        for(int i = 0; i < M; i++) {
            long sum = B[i];
            subB.add(sum);
            for(int j = i + 1; j < M; j++) {
                sum += B[j];
                subB.add(sum);
            }
        }
        //subA, subB 정렬하기
        Collections.sort(subA);
        Collections.sort(subB, Collections.reverseOrder());

        long result = 0;
        int ptA = 0;
        int ptB = 0;

        while(true) {
            long currentA = subA.get(ptA);
            long target = T - currentA;
            //currentB == target -> subA, subB 같은 수 개수 체크 -> 답구하기, ptA+, ptB+
            if(subB.get(ptB) == target) {
                long countA = 0;
                long countB = 0;

                while(ptA < subA.size() && subA.get(ptA) == currentA){
                    countA++;
                    ptA++;
                }

                while(ptB < subB.size() && subB.get(ptB) == target) {
                    countB++;
                    ptB++;
                }

                result += countB*countA;
            }else if(subB.get(ptB) > target) {
            //currentB > target -> ptB++
                ptB++;
            }else{
            //currentB < target -> ptA++
                ptA++;
            }

            //탈출조건
            if(ptA >= subA.size() || ptB >= subB.size()) {
                break;
            }
        }

        System.out.println(result);
    }

}
