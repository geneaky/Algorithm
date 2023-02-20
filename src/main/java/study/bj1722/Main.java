package study.bj1722;

import java.util.*;
import java.io.*;

public class Main {

    static int N, k;

    static int[] factorial = new int[21];
    static boolean[] visited = new boolean[21];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1722/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        factorial[0] = 1;
        for(int i = 1; i < 21; i++) {
            factorial[i] = factorial[i-1] * i;
        }

        if( k == 1) {
            long target = Long.parseLong(st.nextToken());
            int result[] = new int[N];
            for(int i = 0; i < N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(visited[j]) continue;
                    if(factorial[N-i-1] < target) {
                        target -= factorial[N-i-1];
                    }else{
                        result[i] = j;
                        visited[j] = true;
                        break;
                    }
                }
            }

            for(int i = 0; i < N; i++) {
                System.out.print(result[i] + " ");
            }

        } else {
            int[] map = new int[N];
            for(int i = 0; i < N; i++) {
                map[i] = Integer.parseInt(st.nextToken());
            }

            long answer = 1;
            for(int i = 0; i < N; i++) {
                for(int j = 1; j < map[i]; j++) {
                    if(!visited[j]) {
                        answer += factorial[N-i-1];
                    }
                }

                visited[map[i]] = true;
            }

            System.out.println(answer);
        }
    }

}