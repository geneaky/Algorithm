package study.bj1062;

import java.util.*;
import java.io.*;

public class Main {

    static int N,K;

    static boolean[] alphabets;

    static String[] words;

    static int max = 0;

    static int temp = 5;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1062/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        alphabets = new boolean[26];
        char[] base = {'a', 'c', 'i', 'n', 't'};
        for(int i = 0; i < base.length; i++) {
            alphabets[base[i] - 'a'] = true;
        }

        words = new String[N];

        for(int i = 0; i < N; i++) {
            words[i] = br.readLine().replaceAll("[acint]","");
        }

        if(temp > K) {
            System.out.println(0);
        } else if(temp == K) {
            System.out.println(count());
        }else{
            for (int i = 0; i < 26; i++) {
                if (!alphabets[i]) {
                    dfs(i);
                }
            }

            System.out.println(max);
        }
    }

    private static void dfs(int idx) {
        //체크인
        alphabets[idx] = true;
        temp++;

        //도착지인가?
        if (temp == K) {
            max = Math.max(max, count());
        }
        else{

        //연결된곳 순회
        for(int i = idx+1; i < 26; i++) {
        //갈 수 있는가?
            if (!alphabets[i]) {
        //간다
                dfs(i);
            }
        }
        }

        //체크 아웃
        temp--;
        alphabets[idx] = false;
    }

    private static int count() {
        int ret = 0;

        for(int i = 0; i < N; i++) {
            String word = words[i];
            boolean flag = true;
            for(int j = 0; j < word.length(); j++) {
                if (!alphabets[word.charAt(j) - 'a']) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                ret++;
            }
        }

        return ret;
    }
}