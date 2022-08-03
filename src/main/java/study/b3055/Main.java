package study.b3055;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //                우, 좌, 위, 아래
    static int[] yy = {0, 0, -1, 1};
    static int[] xx = {1, -1, 0 , 0};
    static int R,C;
    static char[][] map;

    static int[][] dp;

    static boolean found;

    static int ret;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/study/b3055/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        //물과 고슴도치가 동시에 움직이기 때문에 큐를 사용한다.

        //맵 초기화
        map = new char[R][C];
        dp = new int[R][C];

        Queue<Node> q = new LinkedList<>();
        Node S = null;
        for(int y = 0; y < R; y++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for(int x = 0; x < C; x++) {
                map[y][x] = temp.charAt(x);
                if(map[y][x] == 'S') {
                    S = new Node('S',y, x);
                }

                if(map[y][x] == '*') {
                    q.offer(new Node('*',y, x));
                }
            }
        }
        q.offer(S);


        while(!q.isEmpty()) {
            //큐에서 꺼낸다
            Node temp = q.poll();
            //도착지인가?
            if(temp.c == 'D') {
                found = true;
                ret = dp[temp.y][temp.x];
                break;
            }
            //연결된곳 순회
            for(int i = 0; i < 4; i++) {
                 //갈 수 있는가? -> map안, 방문하지 않은곳, . 인곳
                int ty = temp.y + yy[i];
                int tx = temp.x + xx[i];
                //공통 map 범위
                if(0 <= tx && tx < C && 0 <= ty && ty < R) {
                    if(temp.c == '*') {
                        if(map[ty][tx] == '.' || map[ty][tx] == 'S'){
                           //간다
                            map[ty][tx] = '*';
                            //큐에 넣는다.
                            q.offer(new Node('*', ty, tx));
                        }
                    } else if(temp.c == 'S' || temp.c == '.'){
                        if((map[ty][tx] == 'D' || map[ty][tx] == '.') && dp[ty][tx]==0){
                            //간다
                            dp[ty][tx] = dp[temp.y][temp.x] + 1;
                            //큐에 넣는다.
                            q.offer(new Node(map[ty][tx], ty, tx));
                        }
                    }
                }

            }
        }

        if(found) {
            System.out.println(ret);
        } else {
            System.out.println("KAKTUS");
        }

    }

}

class Node {
    int y;
    int x;

    int c;

    public Node(char c, int y, int x) {
        this.c = c;
        this.y = y;
        this.x = x;
    }
}