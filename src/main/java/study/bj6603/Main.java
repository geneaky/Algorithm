package study.bj6603;

import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder result = new StringBuilder();
    static int[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj6603/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());

        while(size != 0) {
            list = new int[size];
            visited = new boolean[size];
            for(int i = 0; i < size; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                visited[i] = true;
                temp.add(list[i]);
                back(temp,  6);
                temp.remove(temp.size()-1);
                visited[i] = false;
            }
            result.append('\n');
            st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());
        }

        System.out.println(result.toString());
    }

    private static void back(List<Integer> temp, int i) {
        if(i == 1) {
            StringBuilder sb = new StringBuilder();
            for(Integer t : temp) {
                sb.append(t);
                sb.append(" ");
            }
            result.append(sb.toString().trim()+"\n");
            return;
        }

        for(int j = 0; j < list.length; j++) {
            if(visited[j]) {
                continue;
            }

            if(temp.get(temp.size()-1) >= list[j]) {
                continue;
            }
            visited[j] = true;
            temp.add(list[j]);
            back(temp, i-1);
            temp.remove(temp.size()-1);
            visited[j] = false;
        }
    }
}