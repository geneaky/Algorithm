package study.bj1063;

import java.util.*;
import java.io.*;

public class Main {

    static int[][] chess = new int[8][8];
    static int dol_y, dol_x, king_y, king_x;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1063/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] kings = st.nextToken().toCharArray();
        king_x = kings[0] - 'A';
        king_y = 7 -(kings[1] -'1');
        chess[king_y][king_x] = 10;
        char[] dolls = st.nextToken().toCharArray();
        dol_x = dolls[0] - 'A';
        dol_y = 7 - (dolls[1] - '1');
        chess[dol_y][dol_x] = 1;

        int count = Integer.parseInt(st.nextToken());
        while(count!=0) {
            String move = br.readLine();
            int next_y = king_y;
            int next_x = king_x;

            int next_dy = dol_y;
            int next_dx = dol_x;

            switch (move){
                case "R": {
                    next_x++;
                    next_dx++;
                    break;
                }
                case "L" :{
                    next_x--;
                    next_dx--;
                    break;
                }
                case "B" :{
                    next_y++;
                    next_dy++;
                    break;
                }
                case "T" :{
                    next_y--;
                    next_dy--;
                    break;
                }
                case "RT" :{
                    next_y--;
                    next_x++;
                    next_dy--;
                    next_dx++;
                    break;
                }
                case "LT" :{
                    next_y--;
                    next_x--;
                    next_dy--;
                    next_dx--;
                    break;
                }
                case "RB" :{
                    next_y++;
                    next_x++;
                    next_dy++;
                    next_dx++;
                    break;
                }
                case "LB" :{
                    next_y++;
                    next_x--;
                    next_dy++;
                    next_dx--;
                    break;
                }
            }

            if(0<= next_y && next_y < 8 && 0<= next_x && next_x < 8) {
                if(chess[next_y][next_x] == 1) {
                    if(0<= next_dy && next_dy < 8 && 0<= next_dx && next_dx < 8) {
                        chess[king_y][king_x] = 0;
                        chess[next_y][next_x] = 10;
                        chess[next_dy][next_dx] = 1;
                        king_y = next_y;
                        king_x = next_x;
                        dol_y = next_dy;
                        dol_x = next_dx;
                    }
                }else if(chess[next_y][next_x] == 0) {
                    chess[king_y][king_x] = 0;
                    king_y = next_y;
                    king_x = next_x;
                    chess[king_y][king_x] = 10;
                }
            }

            count--;
        }

        System.out.println(Character.toString(king_x + 'A') + (7-king_y+1));
        System.out.println(Character.toString(dol_x + 'A') + (7-dol_y+1));
    }
}