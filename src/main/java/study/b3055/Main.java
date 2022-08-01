package study.b3055;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //                우, 좌, 위, 아래
    static int[] tx = {1, -1, 0 , 0};
    static int[] ty = {0, 0, -1, 1};
    static int R,C;
    static char[][] map;

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/study/b3055/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        //물과 고슴도치가 동시에 움직이기 때문에 큐를 사용한다.

        //맵 초기화
        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if(map[i][j] == 'S') {

                }

                if(map[i][j] == '*') {

                }
            }
        }

        //큐에서 꺼낸다
        //도착지인가?
        //연결된곳 순회
        //갈 수 있는가?
        //간다
        //큐에 넣는다.

    }

}
