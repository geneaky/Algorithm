package sds.day1.b1759;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class B1759AS {

    static int L;
    static int C;

    static char[] data;

    static List<String> ret;

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("src/main/java/sds/day1/b1759/input.txt"));
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();

        data = new char[C];

        for(int i = 0; i < C; i++) {
            data[i] = sc.next().charAt(0);
        }

        Arrays.sort(data);

        ret = new LinkedList<>();

        dfs(0,0,0,-1,"");

        for (String s : ret) {
            System.out.println(s);
        }

    }

    public static void dfs(int length, int ja, int mo, int current, String pwd) {
        //체크인 - 생략 가능
        //목적지인가? length == L => ja 개수, mo 개수 확인 => 암호 가능 판별
        if(length == L ) {
            if(ja >= 2 && mo >= 1) {
                ret.add(pwd);
            }
        }else{
            //연결된 곳 순회 : current+1 ~ c
            for (int i = current + 1; i < C; i++) {

                //갈 수 있는가? : 생략 가능
                // 간다 -> ja, mo
                if (data[i] == 'a' || data[i] == 'e' || data[i] == 'i' || data[i] == 'o'
                    || data[i] == 'u') {
                    dfs(length+1, ja, mo+1, i, pwd + data[i]);
                }else{
                    dfs(length+1, ja+1, mo, i, pwd + data[i]);
                }
            }
        }
        //체크 아웃 - 생략 가능

    }
}
