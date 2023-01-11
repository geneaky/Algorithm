package study.bj15649;

import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj15649/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer> temp = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            temp.add(i);
            back(temp, M-1);
            temp.remove(temp.size()-1);
        }
    }

    private static void back(List<Integer> list, int m) {
        if(m == 0) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                sb.append(" ");
            }
            System.out.println(sb.toString().trim());
            return;
        }

        for(int j = 1; j <=N; j++) {
            if(list.contains(j)) {
                continue;
            }
            list.add(j);
            back(list, m-1);
            list.remove(list.size()-1);
        }
    }
}