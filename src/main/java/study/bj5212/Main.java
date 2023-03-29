package study.bj5212;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj5212/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        String[][] map = new String[R][C];
        boolean[][] visited = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            String[] split = br.readLine().split("");
            for(int j = 0; j < C; j++){
                map[i][j] = split[j];
            }
        }

        int[] ty = {0, 0, 1, -1};
        int[] tx = {1,-1, 0, 0};

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                int count = 0;

                for(int k = 0; k < 4; k++){
                    int yy = i + ty[k];
                    int xx = j + tx[k];
                    if(0<= yy && yy < R && 0 <= xx && xx < C) {
                        if(map[yy][xx].equals(".")) {
                            count++;
                        }
                    }
                }

                if(i == 0) {
                    count++;
                }

                if(i == R-1){
                    count++;
                }

                if(j == 0) {
                    count++;
                }

                if(j == C-1) {
                    count++;
                }

                if(count >= 3) {
                    visited[i][j] = true;
                }
            }
        }

        List<Integer> ylange = new ArrayList<>();
        List<Integer> xlange = new ArrayList<>();


        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(visited[i][j]) {
                    map[i][j] = ".";
                }

                if(map[i][j].equals("X")) {
                    ylange.add(i);
                    xlange.add(j);
                }
            }
        }

        Collections.sort(ylange);
        Collections.sort(xlange);

        if((ylange.size() == 0 && xlange.size() ==0) || (ylange.size()==1&&xlange.size()==1)) {
            System.out.println("X");
        }else{
            for(int i = ylange.get(0); i <= ylange.get(ylange.size()-1); i++) {
                for(int j = xlange.get(0); j <= xlange.get(xlange.size()-1); j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
}