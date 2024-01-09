package study.bj1212;

import java.util.*;
import java.io.*;
import jdk.jfr.Unsigned;

public class Main {


    // ! string 연산에서 시간 소모가 많기때문에 stringbuilder를 사용하자
    // * 숫자 character에서 '0'을 뺀 결과가 해당 숫자를 10진수로 표현한 값이기 때문에 별도의 컨버팅 없이 사용하기 위해 '0'을 뺀것
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1212/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        String octal = st.nextToken();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < octal.length(); i++) {
            String binaryString = Integer.toBinaryString(octal.charAt(i) - '0');
            if(binaryString.length() == 2 && i != 0) {
                binaryString = "0" + binaryString;
            }else if(binaryString.length() == 1 && i != 0) {
                binaryString = "00" + binaryString;
            }

            sb.append(binaryString);
        }

        System.out.println(sb);
    }
}