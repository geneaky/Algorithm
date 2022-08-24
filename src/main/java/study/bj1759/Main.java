package study.bj1759;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    static int L;
    static int C;
    static char[] alpha;
    static boolean[] visited;
    static char[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("src/main/java/study/bj1759/input.txt"));
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();

        alpha = new char[C];

        for (int i = 0; i < C; i++) {
            alpha[i] = sc.next().charAt(0);
        }

        Arrays.sort(alpha);

        answer = new char[L + 1];
        answer[L] = '\n';

        visited = new boolean[123];
        visited['a'] = visited['e'] = visited['i'] = visited['o'] = visited['u'] = true;

        dfs(-1, 0, 0, 0);

        System.out.println(sb);
    }

    public static void dfs(int n, int m, int mo, int za) {
        if(m == L) {
            if(mo >= 1 && za >= 2) sb.append(answer);
            return;
        }
        for(int i = n + 1; i <= C - L + m; i++) {
            answer[m] = alpha[i];
            dfs(i, m + 1, mo + (visited[alpha[i]] ? 1 : 0), za + (visited[alpha[i]] ? 0 : 1));
        }
    }
}