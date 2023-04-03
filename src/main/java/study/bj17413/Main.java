package study.bj17413;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj17413/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] split = input.split("");

        StringBuilder sb = new StringBuilder();

        boolean safetyzone = false;

        StringBuilder temp = new StringBuilder();
        for(String s : split) {
            if(s.equals("<")) {
                safetyzone = true;
                if(!temp.toString().isEmpty()) {
                    sb.append(temp.reverse());
                    temp = new StringBuilder();
                }
                sb.append(s);
                continue;
            }

            if(s.equals(">")) {
                safetyzone = false;
                sb.append(s);
                continue;
            }

            if(safetyzone) {
                sb.append(s);
            }else{
                if(s.equals(" ") || s.equals("<")) {
                    sb.append(temp.reverse());
                    sb.append(s);
                    temp = new StringBuilder();
                }else{
                    temp.append(s);
                }
            }
        }

        if (!temp.toString().isEmpty()) {
            sb.append(temp.reverse());
        }
        
        System.out.println(sb.toString());
    }
}