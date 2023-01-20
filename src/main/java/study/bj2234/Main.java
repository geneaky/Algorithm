package study.bj2234;

import java.util.*;
import java.io.*;

public class Main {

    static int N,M;
    static int[][] room, arr;
    static int max = 0;
    static int[] area;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj2234/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        room = new int[M][N];
        arr = new int[M][N];
        area = new int[2501]; //최대 50 * 50 행렬이기 때문

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int c = 1;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(room[i][j] == 0) {
                    bfs(new Pos(i,j), c);
                    max = Math.max(max, area[c]);
                    c++;
                }
            }
        }


        int sum = 0;
        int[] y = {0, 1, 0, -1};
        int[] x = {1, 0, -1, 0};
        for(int i = 0; i< M; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < 4; k++) {
                    int nr = i + y[k];
                    int nc = j + x[k];

                    if((0<=nr && nr < M) && (0 <= nc && nc < N) && room[i][j] != room[nr][nc]) {
                        sum = Math.max(sum, area[room[i][j]] + area[room[nr][nc]]);
                    }
                }
            }
        }

        System.out.println(c-1);
        System.out.println(max);
        System.out.println(sum);
    }

    public static void bfs(Pos start, int c) {
        Queue<Pos> q = new LinkedList<>();

        q.offer(start);
        room[start.r][start.c] = c;

        while(!q.isEmpty()) {
            Pos pos = q.poll();
            area[c]++; //방 번호별 넓이 증가

            int num = arr[pos.r][pos.c];
            for(int i = 0; i < 4; i++) {
                Pos p;
                if(num % 2 == 0) {
                    switch(i) {
                        case 0:
                            p = new Pos(pos.r, pos.c - 1);
                            break;
                        case 1:
                            p = new Pos(pos.r-1, pos.c);
                            break;
                        case 2:
                            p = new Pos(pos.r, pos.c+1);
                            break;
                        default:
                            p = new Pos(pos.r+1, pos.c);
                            break;
                    }

                    if((0 <= p.r && p.r < M) && (0 <= p.c && p.c <= N) && room[p.r][p.c] == 0) {
                        q.offer(p);
                        room[p.r][p.c] = c;
                    }
                }

                num /= 2;
            }
        }
    }

    public static class Pos {

        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}