package sds.day1.b3055;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PipedInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B3055AS {

    static class Point {
        int y;
        int x;
        char type;

        public Point(int y, int x, char type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    //조이스틱              좌, 우, 위, 아래
    static final int[] MX = {-1, 1, 0, 0};
    static final int[] MY = {0, 0, -1, 1};
    static int R;
    static int C;
    static char[][] map;
    static Queue<Point> queue;
    static int[][] dp;

    static boolean foundAnswer;

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("src/main/java/sds/day1/b3055/input.txt"));
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();

        C = sc.nextInt();

        map = new char[R][C];
        dp = new int[R][C];
        queue = new LinkedList<>();

        Point st = null;

        for(int i = 0; i < R; i++) {
            String temp = sc.next();
            for(int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j);
                if(map[i][j] == '*') {
                    queue.add(new Point(i,j,'*'));
                }else if(map[i][j] == 'S') {
                    st = new Point(i,j,'S');
                }
            }
        }

        queue.add(st);



        while(!queue.isEmpty()) {
            //큐에서 꺼내옴 -> *, S, .,D
            Point p = queue.poll();
            //목적지 인가? -> D
            if(p.type == 'D'){
                foundAnswer = true;
                break;
            }
            //연결된곳을 순회 -> 좌우위아래
            for(int i = 0; i < 4; i++) {
                int ty = p.y + MY[i];
                int tx = p.x + MX[i];
                //갈 수 있는가? -> (공통) : 맵안에 들어오는가
                if(0 <= ty && ty < R && 0 <= tx && tx < C) {
                    if(p.type == 'S' || p.type == '.') {
                        //갈 수 있는가? -> (고슴도치) : . or D, 방문하지 않은곳
                        if((map[ty][tx] == '.' || map[ty][tx] == 'D') && dp[ty][tx] == 0){
                            //체크인 (고슴도치) : dp[][] = 이동거리
                            dp[ty][tx] = dp[p.y][p.x] + 1;
                            //큐에 넣음
                            queue.add(new Point(ty, tx, map[ty][tx]));
                        }
                    }else if(p.type == '*') {
                        //갈 수 있는가? -> (물) : .
                        if(map[ty][tx] == '.' || map[ty][tx] == 'S') {
                            //체크인 (물) : map[][] = *
                            map[ty][tx] = '*';
                            //큐에 넣음
                            queue.add(new Point(ty, tx, '*'));

                        }
                    }
                }

            }
        }

    }

}
