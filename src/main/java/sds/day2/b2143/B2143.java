package sds.day2.b2143;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B2143 {

    static int T, N , M;

    static int[] A;
    static int[] B;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/main/java/sds/day2/b2143/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        B = new int[M];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> subA = new ArrayList<>();
        List<Integer> subB = new ArrayList<>();

        for(int i = 0; i < A.length; i++) {
            int temp = A[i];
            subA.add(temp);
            for(int j =i+1; j < A.length; j++) {
                temp += A[j];
                subA.add(temp);
            }
        }
        for(int i = 0; i < B.length; i++) {
            int temp = B[i];
            subB.add(temp);
            for(int j =i+1; j < B.length; j++) {
                temp += B[j];
                subB.add(temp);
            }
        }

        Collections.sort(subA);
        Collections.sort(subB, Collections.reverseOrder());

        int pointA = 0, pointB = 0, count = 0;
        while(true){
            int tempA = subA.get(pointA);
            long target = T - tempA;
            if(target == subB.get(pointB)) {
                int countA = 0;

                while(pointA < subA.size() && subA.get(pointA) == tempA) {
                    countA++;
                    pointA++;
                }

                int countB = 0;
                while(pointB < subB.size() && subB.get(pointB) == T-tempA) {
                    countB++;
                    pointB++;
                }

                count += countA * countB;
            }else if (subB.get(pointB) > target) {
                pointB++;
            }else {
                pointA++;
            }

            if(pointA >= subA.size() || pointB >= subB.size()) {
                break;
            }
        }

        System.out.println(count);
    }

}
