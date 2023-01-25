package study.bj1525;

import java.util.*;
import java.io.*;

public class Main {

    static int[] ty = {0, 0, 1, -1};
    static int[] tx = {1,-1, 0, 0};


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1525/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringBuilder start = new StringBuilder();

        for(int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                String s = st.nextToken();
                if (s.equals("0")) {
                    start.append("9");
                }else{
                    start.append(s);
                }
            }
        }

        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();

        queue.offer(start.toString());
        map.put(start.toString(), 0);

        while(!queue.isEmpty()) {
            String temp = queue.poll();
            int nineLoc = temp.indexOf("9");
            int x = nineLoc/3;
            int y = nineLoc%3;

            for(int i = 0; i < 4; i++) {
                int xx = x + tx[i];
                int yy = y + ty[i];

                int move = xx*3+yy;
                if(0<=xx&&xx<3&&0<=yy&&yy<3) {
                    StringBuilder next = new StringBuilder(temp);
                    char c = temp.charAt(move);
                    next.setCharAt(nineLoc, c);
                    next.setCharAt(move,'9');
                    String nextTemp = next.toString();
                    if(!map.containsKey(nextTemp)) {
                        queue.offer(nextTemp);
                        map.put(nextTemp,map.get(temp)+1);
                    }
                }
            }
        }

        if(map.containsKey("123456789")) {
            System.out.println(map.get("123456789"));
        } else {
            System.out.println(-1);
        }
    }
}