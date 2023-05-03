package study.bj9655;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(
            "/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj9655/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());

        int user = 1;
        while(number > 0) {
            if(number > 3) {
                number -= 3;
            }else{
                number -= 1;
            }

            user = user == 0? 1 : 0;
        }

        if(user == 0) {
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }
}