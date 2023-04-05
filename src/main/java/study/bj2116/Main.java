package study.bj2116;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj2116/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][6];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 6; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int k = 1; k <= 6; k++) {
            int temp = 0;
            int h = k;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < 6; j++) {
                    if(map[i][j] == h){
                        temp += insert(map,i,j);
                        if(j == 0) h = map[i][5];
                        if(j == 5) h = map[i][0];
                        if(j == 1) h = map[i][3];
                        if(j == 3) h = map[i][1];
                        if(j == 2) h = map[i][4];
                        if(j == 4) h = map[i][2];
                        break;
                    }
                }
            }

            list.add(temp);
        }

        Collections.sort(list);

        System.out.println(list.get(list.size()-1));
    }

    private static int insert(int[][] map, int i, int j) {
        List<Integer> temp = new ArrayList<>();
        for(int t = 0; t < 6; t++) {
            if(j == 0 || j == 5) {
                if(t == 0 || t == 5) continue;
            }

            if(j == 1 || j == 3) {
                if(t ==1 || t == 3) continue;
            }

            if(j ==2 || j == 4) {
                if(t == 2 || t == 4) continue;
            }
            temp.add(map[i][t]);
        }
        Collections.sort(temp);

        return temp.get(temp.size() - 1);
    }
}