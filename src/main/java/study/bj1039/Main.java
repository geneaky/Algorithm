package study.bj1039;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int K,len,sol;
    static String N;
    static int[][] visit;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/study/b1039/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = st.nextToken();
        K = Integer.parseInt(st.nextToken());

        len = N.length();
        visit = new int[K+1][1000001];

        sol = -1;
        sol = dfs(N,0);

        System.out.println(sol);
    }

    static int dfs(String strN, int depth) {
        int num = Integer.parseInt(strN);
        if(depth == K) {
            return num;
        }


        int ret = visit[depth][num];

        if(ret != 0) {
            //방문한 적이 있다면 해당 결과 리턴
            return ret;
        }
        ret = -1;

        // 0 <= i < j <= len(N의 자릿수)
        for(int i = 0; i < len-1; i++) {
            for(int j = i+1; j < len; j++) {
                // 0 은 맨 앞으로 올 수 없음
                if(i == 0 && strN.charAt(j) == '0') continue;

                String tempStr = swapLoc(strN, i, j);

                int tempRet = dfs(tempStr, depth + 1);
                if(tempRet > ret) {
                    ret = tempRet;
                }
            }
        }

        visit[depth][num] = ret;
        return ret;
    }

    static String swapLoc(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        return String.valueOf(chars);
    }
}