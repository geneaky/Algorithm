package study.bj2580;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    //가로 세로 dfs
    // 3X3  라인에서도 1~9
    // 가로 세로 1~9
    static int[][] sdoku = new int[9][9];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/study/bj2580/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //y축 한칸씩 확인
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sdoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
    }

    public static void dfs(int y, int x) {
        if(x == 9) {
            dfs(y+1,0);
            return;
        }

        if(y == 9) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    System.out.print(sdoku[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        if(sdoku[y][x] == 0) {
            for(int i = 1; i <= 9; i++) {
                if(check(y,x,i)) {
                    sdoku[y][x] = i;
                    dfs(y, x+1);
                }
            }
            sdoku[y][x] = 0;
            return;
        }

        dfs(y,x+1);
    }

    private static boolean check(int y, int x, int value) {

        for(int i = 0; i < 9; i++) {
            if(sdoku[y][i] == value) {
                return false;
            }
        }

        for(int i = 0; i < 9; i++) {
            if(sdoku[i][x] == value) {
                return false;
            }
        }

        int row = (y/3)*3;
        int col = (x/3)*3;

        for(int i = row; i < row+3; i++) {
            for(int j = col; j < col+3; j++) {
                if(sdoku[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}