package study.bj7569;

import java.util.*;
import java.io.*;

public class Main {

    static int X, Y;
    static int Z;

    static int[][][] map;
    static boolean[][][] visited;

    static int result = -1;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj7569/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken()); //x
        Y = Integer.parseInt(st.nextToken()); //y
        Z = Integer.parseInt(st.nextToken()); //z

        map = new int[Z][Y][X];
        visited = new boolean[Z][Y][X];

        Queue<Node> queue = new LinkedList<>();

        for(int i = 0; i < Z; i++) {
            for(int j = 0; j < Y; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < X; k++) {
                    int number = Integer.parseInt(st.nextToken());
                    map[i][j][k] = number;
                    if(number == 1) {
                        queue.offer(new Node(j, k, i,0));
                    }

                    if(number == -1) {
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            if(visited[temp.Z][temp.Y][temp.X]) continue;
            visited[temp.Z][temp.Y][temp.X] = true;
            result = Math.max(result, temp.day);
            if(temp.X-1 >=0) {
                queue.offer(new Node(temp.Y, temp.X - 1, temp.Z, temp.day+1));
            }
            if(temp.X+1 < X) {
                queue.offer(new Node(temp.Y, temp.X+1, temp.Z, temp.day+1));
            }

            if(temp.Y-1 >=0) {
                queue.offer(new Node(temp.Y-1, temp.X, temp.Z, temp.day+1));
            }
            if(temp.Y+1 < Y) {
                queue.offer(new Node(temp.Y + 1, temp.X, temp.Z, temp.day+1));
            }

            if(temp.Z-1 >=0){
                queue.offer(new Node(temp.Y, temp.X, temp.Z - 1, temp.day+1));
            }
            if(temp.Z+1 < Z){
                queue.offer(new Node(temp.Y, temp.X, temp.Z + 1, temp.day+1));
            }
        }

        for(int i = 0; i < Z; i++) {
            for(int j = 0; j < Y; j++) {
                for(int k = 0; k < X; k++) {
                    if(!visited[i][j][k]) {
                        result = -1;
                    }
                }
            }
        }

        System.out.println(result);
    }

    public static class Node {
        int Y;
        int X;
        int Z;
        int day;

        public Node(int y, int x, int z, int inputDay) {
            Y = y;
            X = x;
            Z = z;
            this.day = inputDay;
        }
    }
}