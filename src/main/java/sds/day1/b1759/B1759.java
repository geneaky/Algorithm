package sds.day1.b1759;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B1759 {

    static int L;
    static int C;

    static boolean[] visited;

    static List<String> ret = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("src/main/java/sds/day1/b1759/input.txt"));
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();

        String[] alpha = new String[C];
        visited = new boolean[C];

        for(int i = 0; i < C; i++) {
            alpha[i] = sc.next();
        }

        Arrays.sort(alpha);

        for(int i = 0; i < L; i++) {
            dfs(i,new StringBuilder(), alpha);
        }

        for(String s : ret) {
            System.out.println(s);
        }

    }

    public static void dfs(int index,StringBuilder sb, String[] alpha) {
        //체크인
        visited[index] = true;
        sb.append(alpha[index]);
        //목적지인가?
        if(sb.length() == L) {
            String str = sb.toString();
            if(valid(str)) {
                ret.add(str);
            }
        }
        //연결된 곳 순회
        for(int i = index+1; i < alpha.length; i++) {
            //갈 수 있는가?
            if(!visited[i]) {
                //간다
                dfs(i, sb, alpha);
            }
        }
        //체크 아웃
        sb.delete(sb.length()-1, sb.length());
        visited[index] = false;
    }

    public static boolean valid(String str) {
        //모음 최소 1개 && 자음 최소 2개
        boolean one = str.matches("(.*)[aeiou](.*)");
        boolean tow = str.replaceAll("[aeiou]", "").length() >= 2;

        return one&&tow;
    }
}
