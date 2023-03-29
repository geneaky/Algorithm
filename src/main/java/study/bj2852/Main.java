package study.bj2852;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj2852/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Date current_winner_time = null;
        int win_one = 0;
        int win_two = 0;
        int temp_one = 0;
        int temp_two = 0;

        Date one = new Date(0);
        Date two = new Date(0);

        SimpleDateFormat format = new SimpleDateFormat("mm:ss");
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();

            if (temp.equals("1")) {
                win_one++;
            }else{
                win_two++;
            }

            Date date = format.parse(st.nextToken());

            if (current_winner_time != null) {
                if(win_one > win_two && temp_one > temp_two) {
                    one = new Date(one.getTime() + (date.getTime() - current_winner_time.getTime()));
                    temp_one++;
                }else if(win_two > win_one && temp_two > temp_one) {
                    two = new Date(two.getTime() + (date.getTime() - current_winner_time.getTime()));
                    temp_two++;
                }else if(win_one == win_two && temp_one < temp_two){
                    one = new Date(one.getTime() + (date.getTime() - current_winner_time.getTime()));
                    temp_one++;
                } else if (win_one == win_two && temp_two < temp_one) {
                    two = new Date(two.getTime() + (date.getTime() - current_winner_time.getTime()));
                    temp_two++;
                }
            }

            current_winner_time = date;
        }

        Date date = new Date(1000 * 60 * 48);
        if(win_one >win_two) {
            one = new Date(one.getTime() + (date.getTime() - current_winner_time.getTime()));
        }else if(win_two > win_one) {
            two = new Date(two.getTime() + (date.getTime() - current_winner_time.getTime()));
        }

        System.out.println(format.format(new Date(2000L)));
        System.out.println(format.format(one));
        System.out.println(format.format(two));
    }
}