package study.bj11780;

import java.util.*;
import java.io.*;

public class Main {

    static int n, m;

    static int[][] map;
    static int[][] dist;

    static int INF = 10_000_001;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj11780/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        map = new int[n][n];
        dist = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dist[i][j] = INF;
                if(i==j) continue;
                map[i][j] = INF;
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int value = Integer.parseInt(st.nextToken());

            map[start][end] = Math.min(map[start][end], value);
            dist[start][end] = start;
        }

        //거쳐가는 노드
        for(int k = 0; k < n; k++) {
            //시작노드
            for(int i = 0; i < n; i++) {
                //도착노드
                for(int j = 0; j < n; j++) {
                    if(map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                        dist[i][j] = dist[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 10_000_001) {
                    sb.append(0 + " ");
                }else{
                    sb.append(map[i][j] + " ");
                }
            }
            sb.append("\n");
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(dist[i][j] == INF) {
                    sb.append(0 + "\n");
                }else {
                    int pre = j;
                    stack.push(j);
                    while(i != dist[i][pre]) {
                        pre = dist[i][pre];
                        stack.push(pre);
                    }
                    sb.append((stack.size() + 1) + " ");
                    sb.append(i + " ");
                    while(!stack.empty()) {
                        sb.append(stack.pop() + " ");
                    }
                    sb.append("\n");
                }
            }
        }

        System.out.println(sb.toString());
    }
}