package study.bj9663;

import java.io.*;

public class Main {

    //백트랙킹으로 8번 모든 경우의 수로 놓되 가로, 세로, 대각선에 다른 퀸이 없는 상황에서만 퀸을 8번 놓을 수 있을때 카운트

    static int N;
    static boolean[][] board;

    static int ret = 0;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj9663/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new boolean[N][N];

        dfs(0,0, 0);

        System.out.println(ret);
    }

    private static void dfs(int y, int x, int count) {
        //체크인
        count++;
        //목적지인가?
        if(count == N) {
            ret++;
            return;
        }
        //연결된곳 순회
        for(int i = y; i < N; i++) {
            for(int j = x; j < N; j++) {
                //갈 수 있는가?
                if(board[i][j] == false) {
                    //간다
                    check(i,j, true);
                    dfs(i,j,count);
                    check(i,j, false);
                }
            }
        }
        //체크 아웃
        count--;
    }

    private static void check(int y, int x, boolean flag) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i == y) {
                    board[i][j] = flag;
                }

                if(j == x) {
                    board[i][j] = flag;
                }
            }
        }
        // (y+1,x+1), (y+1,x-1), (y-1,x+1), (y-1,x-1)
        daegak(y,x,flag, 1, 1);
        daegak(y,x,flag, 1, -1);
        daegak(y,x,flag, -1, 1);
        daegak(y,x,flag, -1, -1);
    }

    private static void daegak(int y, int x, boolean flag, int ty, int tx) {


        if(0<= y+ty && y+ty < N && 0 <= x+tx && x+tx < N) {
            board[y+ty][x+tx] = flag;
            daegak(y+ty,x+tx,flag,ty,tx);
        }
    }
}