package study.bj14891;

import java.util.*;
import java.io.*;

public class Main {

    static int[][] map = new int[4][8];
    static int K;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj14891/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int i = 0; i < 4; i++) {
            String[] split = br.readLine().split("");
            for(int j = 0; j < 8; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        K = Integer.parseInt(br.readLine());
        boolean[] visited;

        while(K-- != 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int topNumber = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());
            visited = new boolean[4];

            dfs(visited, topNumber, direction);

        }
        int result = 0;

        result += map[0][0] == 0 ? 0 : 1;
        result += map[1][0] == 0 ? 0 : 2;
        result += map[2][0] == 0 ? 0 : 4;
        result += map[3][0] == 0 ? 0 : 8;

        System.out.println(result);
    }

    private static void dfs(boolean[] visited, int topNumber, int direction) {
        if (visited[topNumber]) return;
        visited[topNumber] = true;

        //index 2, 6 확인
        if(topNumber-1 >= 0 && map[topNumber][6] != map[topNumber-1][2]) {
            dfs(visited, topNumber-1, direction*-1);
        }

        if(topNumber+1 < 4 && map[topNumber][2] != map[topNumber+1][6]) {
            dfs(visited, topNumber + 1, direction*-1);
        }

        Deque<Integer> temp = new ArrayDeque<>();
        if(direction == 1) {
            for(int i = 0; i < 8; i++) {
                temp.add(map[topNumber][i]);
            }
            temp.addFirst(temp.removeLast());

            for(int i = 0; i < 8; i++) {
                map[topNumber][i] = temp.removeFirst();
            }
        }else{
            for(int i = 0; i < 8; i++) {
                temp.add(map[topNumber][i]);
            }
            temp.addLast(temp.removeFirst());

            for(int i = 0; i < 8; i++) {
                map[topNumber][i] = temp.removeFirst();
            }
        }
    }
}