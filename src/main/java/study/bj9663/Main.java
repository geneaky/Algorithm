package study.bj9663;

import java.io.*;

public class Main {

    //백트랙킹으로 8번 모든 경우의 수로 놓되 가로, 세로, 대각선에 다른 퀸이 없는 상황에서만 퀸을 8번 놓을 수 있을때 카운트

    static int N;
    static int[] board;

    static int ret = 0;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj9663/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N];

        dfs(0);

        System.out.println(ret);
    }

    private static void dfs(int y) {
        //체크인
        //목적지인가?
        if(y == N) {
            ret++;
            return;
        }
        //연결된곳 순회
        for(int i = 0; i < N; i++) {
            board[y] = i;
            //갈 수 있는가?
            if(check(y)) {
                //간다
                dfs(y+1);
            }
        }
        //체크 아웃
    }

    private static boolean check(int y) {
        for(int i = 0; i < y; i++) {
            if(board[y] == board[i]) {
                return false;
            }
            else if(Math.abs(y - i) == Math.abs(board[y] - board[i])) {
                return false;
            }
        }

        return true;
    }
}