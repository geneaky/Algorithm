package study.bj12904;

import java.util.*;
import java.io.*;

public class Main {

    static int ret = 0;

    static Map<String, Boolean> visited = new HashMap<>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj12904/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String S = st.nextToken();
        String T = br.readLine();


        while(S.length() < T.length()) {
            StringBuilder sb = new StringBuilder();
            if(T.endsWith("A")) {
                T = T.substring(0, T.length() - 1);
            }else{
                T = T.substring(0, T.length()-1);
                T = sb.append(T).reverse().toString();
            }
        }

        if(S.equals(T)) {
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}