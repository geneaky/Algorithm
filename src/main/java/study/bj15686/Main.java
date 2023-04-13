package study.bj15686;

import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;

    static int[][] map;
    static boolean[][] visited;

    static List<int[]> chicken = new ArrayList<>();
    static List<int[]> house = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj15686/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 2) {
                    chicken.add(new int[]{i, j});
                }
                if(val == 1) {
                    house.add(new int[]{i, j});
                }
                map[i][j] = val;
            }
        }

        List<int[]> selectedChicken = new ArrayList<>();
        bruteforce(0, selectedChicken);
        Collections.sort(list);
        System.out.println(list.get(0));
    }

    private static void bruteforce(int startIdx, List<int[]> selectedChicken) {
        if(selectedChicken.size() == M) {
            int tempResult = 0;
            for(int[] h : house) {
                int temp = Integer.MAX_VALUE;
                for(int[] c : selectedChicken) {
                    temp = Math.min(temp, Math.abs(c[0] - h[0]) + Math.abs(c[1] - h[1]));
                }
                tempResult += temp;
            }
            list.add(tempResult);
            return;
        }


        for(int i = startIdx; i < chicken.size(); i++) {
            int[] chk = chicken.get(i);
            selectedChicken.add(chk);
            bruteforce(i+1,selectedChicken);
            selectedChicken.remove(selectedChicken.size() - 1);
        }
    }

}