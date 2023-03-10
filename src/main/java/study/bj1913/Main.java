package study.bj1913;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1913/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int number = Integer.parseInt(br.readLine());

        int[][] map = new int[N+1][N+1];

        int track = N/2 + 1;

        int starty = track-1;
        int startx = track-1;

        int track_start_y = starty-1;
        int track_start_x = startx;

        int left_up_y = starty-1;

        int right_up_y = starty-1;
        int right_up_x = startx+1;

        int left_down_x = startx-1;

        int right_down_y = starty+1;
        int right_down_x = startx+1;

        map[starty][startx] = 1;

        int resulty = 0;
        int resultx = 0;

        int tn = 2;
        for(int i = 0; i < track+2; i++) {
            if(track_start_x < 0 || track_start_y < 0) break;
            for(int j = track_start_x; j <= right_up_x && tn <= N*N; j++) {
                if(tn == number) {
                    resulty = track_start_y;
                    resultx = j;
                }
                map[track_start_y][j] = tn++;
            }

            for(int j = right_up_y+1; j <= right_down_y && tn <= N*N; j++) {
                if(tn == number) {
                    resulty = j;
                    resultx = right_up_x;
                }
                map[j][right_up_x] = tn++;
            }

            for(int j = right_down_x-1; j >= left_down_x && tn <= N*N; j--) {
                if(tn == number) {
                    resulty = right_down_y;
                    resultx = j;
                }
                map[right_down_y][j] = tn++;
            }

            for(int j = right_down_y-1; j >= left_up_y && tn <= N*N; j--) {
                if(tn == number) {
                    resulty = j;
                    resultx = left_down_x;
                }
                map[j][left_down_x] = tn++;
            }

            track_start_y--;
            track_start_x--;

            left_up_y--;

            right_up_y--;
            right_up_x++;

            left_down_x--;

            right_down_y++;
            right_down_x++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N+1; i++) {
            for(int j = 0; j < N+1; j++) {
                if(map[i][j] == 0) continue;
                sb.append(map[i][j]);
                sb.append(" ");
            }
            sb.trimToSize();
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
        resultx++;
        resulty++;
        System.out.println(resulty + " " + resultx);
    }
}