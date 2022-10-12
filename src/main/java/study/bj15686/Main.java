package study.bj15686;

import java.util.*;
import java.io.*;

public class Main {

    static int N,M;

    static int[][] map;

    static int ret = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj15686/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        List<List<Integer>> house = new ArrayList<>();
        List<List<Integer>> chicken = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    List<Integer> h = new ArrayList<>();
                    h.add(i);
                    h.add(j);
                    house.add(h);
                }

                if(map[i][j] == 2) {
                    List<Integer> c = new ArrayList<>();
                    c.add(i);
                    c.add(j);
                    chicken.add(c);
                }
            }
        }


        dfs(house,chicken, 0, 0);
        //집 x,y 좌표를 나타내는 리스트
        //치킨집 x,y 좌표를 나타내는 리스트를 만들어서
        //치킨집 좌표 리스트에서 M개를 선택하는 백트랙킹을 구현해서
        //끝까지 돌렸을 때 가장 최솟값이 나오는 해를 반환한다
        //집은 전부 다 돌아야하는 데이터
        //치킨은 선택적으로 돌아야하는 데이터(백트랙킹)


        System.out.println(ret);
    }

    private static void dfs(List<List<Integer>> house, List<List<Integer>> chicken, int temp, int idx) {
        //체크인
        idx++;
        //목적지인가?
        if(M==idx) {
            ret = Math.min(ret, temp);
            return;
        }
        //연결된 곳 순회
        for(int i = idx; i <= M; i++) {
        //갈 수 있는가?
            int t = 0;
            for(int p = 0; p < house.size(); p++) {
                t += Math.abs(house.get(p).get(0) - chicken.get(i).get(0)) + Math.abs(house.get(p).get(1) - chicken.get(i).get(1));
            }
        //간다
            dfs(house,chicken,temp+t,i+1);
        }
        //체크아웃
        idx--;
    }
}