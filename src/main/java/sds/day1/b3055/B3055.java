package sds.day1.b3055;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B3055 {

    static class Point {
        int x;
        int y;
        char type;
        int visited;

        public Point(int x, int y, char type, int visited) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.visited = visited;
        }
    }

    //조이스틱              좌, 우, 위, 아래
    static final int[] MX = {-1, 1, 0, 0};
    static final int[] MY = {0, 0, -1, 1};
    static int R;
    static int C;
    static char[][] map;
    static Queue<Point> queue;
    static int ret;

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("src/main/java/sds/day1/b3055/input.txt"));
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();

        C = sc.nextInt();

        map = new char[R][C];

        for(int i = 0; i < R; i++) {
            String temp = sc.next();
            for(int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        queue = new LinkedList<>();

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] == '*') {
                    queue.offer(new Point(i,j,'*',0));
                }
            }
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] == 'S') {
                    queue.offer(new Point(i,j, 'S',0));
                }
            }
        }


        while(!queue.isEmpty()) {
            //큐에서 꺼내옴
            Point temp = queue.poll();
            //목적지 인가?
            if(temp.type == 'S' && map[temp.x][temp.y] == 'D') {
                ret = temp.visited;
            }
            //연결된곳을 순회
            if(temp.type == '*') {
                for (int i = 0; i < 4; i++) {
                    int tx = temp.x + MX[i];
                    int ty = temp.y + MY[i];

                    if (tx >= 0 && tx <= map.length - 1 && ty >= 0 && ty <= map[0].length - 1) {
                        //갈 수 있는가?
                        if (map[tx][ty] == '.' || map[tx][ty] == 'S') {
                            //체크인
                            map[tx][ty] = '*';
                            //큐에 넣음
                            queue.offer(new Point(tx, ty, '*', 0));
                        }
                    }
                }
            }else{
                map[temp.x][temp.y] = temp.type;
                for (int i = 0; i < 4; i++) {

                    int tx = temp.x + MX[i];
                    int ty = temp.y + MY[i];

                    if (tx >= 0 && tx <= map.length - 1 && ty >= 0 && ty <= map[0].length - 1) {
                        //갈 수 있는가?
                        if (map[tx][ty] == '.' || map[tx][ty] == 'D') {
                            //체크인
                            //방문했던 곳은 재방문 못하도록 dp[][]에서 판단할 것 이므로 map에 표시하지 않아도됨
//                            map[tx][ty] = 'S';
                            //큐에 넣음
                            queue.offer(new Point(tx, ty, 'S',temp.visited+1));
                        }
                    }
                }
            }
        }

        if(ret != 0) {
            System.out.println(ret);
        }else{
            System.out.println("KAKTUS");
        }

    }

}
