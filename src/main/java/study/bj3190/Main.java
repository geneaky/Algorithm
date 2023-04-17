package study.bj3190;

import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int K;
    static int L;

    static int[][] map;

    public static class Snake {

        static int[] dy = {0,-1,0,1};
        static int[] dx = {1, 0, -1, 0};

        int headY;
        int headX;
        int direction;
        Deque<int[]> body;

        //초기 direction 0
        public Snake(int headY, int headX, int direction) {
            this.headY = headY;
            this.headX = headX;
            this.direction = direction;
            this.body = new ArrayDeque<>();
        }

        public void go() {
            body.offer(new int[]{this.headY, this.headX});
            this.headY += dy[direction];
            this.headX += dx[direction];

            if(map[this.headY][this.headX] == 1) {
//                body.offer(new int[]{this.headY, this.headX});
            }else{
                body.removeFirst();
                body.offer(new int[]{this.headY, this.headX});
            }
        }

        public void left() {
            this.direction = this.direction + 1 > 3 ? 0 : this.direction +1;
        }

        public void right() {
            this.direction = this.direction - 1 < 0 ? 3 : this.direction -1;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj3190/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y-1][x-1] = 1;
        }
        L = Integer.parseInt(br.readLine());

        Snake snake = new Snake(0,0,0);
        int result = 0;
        while(0 < L--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int second = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();

            boolean flag = false;

            for(int i = 0; i < second; i++) {
                int nextY = snake.headY + Snake.dy[snake.direction];
                int nextX = snake.headX + Snake.dx[snake.direction];
                result++;
                if(0<= nextY && nextY < N && 0 <= nextX && nextX < N) {
                    snake.go();
                    Deque<int[]> body = snake.body;
                    for(int k = 0; k < body.size()-1; k++) {
                        int[] poll = body.poll();
                        if(poll[0] == nextY && poll[1] == nextX){
                            flag = true;
                            break;
                        }
                        body.offer(poll);
                    }
                }else{
                    flag = true;
                    break;
                }
            }

            if(direction.equals("L")) {
                snake.left();
            }else{
                snake.right();
            }

            if(flag) {
                break;
            }
        }

        System.out.println(result);
    }
}