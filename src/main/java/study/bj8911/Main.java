package study.bj8911;

import java.awt.Point;
import java.util.*;
import java.io.*;

public class Main {

    public static String[] directions = {"S", "W", "N", "E"};
    public static class Turtle {

        int y;
        int x;

        int direction;

        public Turtle(int y, int x, int direction) {
            this.y = y;
            this.x = x;
            this.direction = direction;
        }

        public void left() {
            if(this.direction - 1 < 0) this.direction = 3;
            else this.direction--;
        }

        public void right() {
            if(this.direction + 1 > 3) this.direction = 0;
            else this.direction++;
        }

        public void forward() {
            if(direction == 0) {
                this.y++;
            }else if(direction == 1) {
                this.x--;
            }else if(direction ==2) {
                this.y--;
            }else{
                this.x++;
            }
        }

        public void backward() {
            if(direction == 0) {
                this.y--;
            }else if(direction == 1) {
                this.x++;
            }else if(direction == 2) {
                this.y++;
            }else {
                this.x--;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj8911/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        List<Integer> results = new ArrayList<>();
        List<Integer> yPoint;
        List<Integer> xPoint;
        while(T != 0) {
            char[] inputs = br.readLine().toCharArray();
            Turtle turtle = new Turtle(0, 0, 2);
            yPoint = new ArrayList<>();
            xPoint = new ArrayList<>();
            yPoint.add(turtle.y);
            xPoint.add(turtle.x);
            for (char input : inputs) {
                if(input == 'F') {
                    turtle.forward();
                    yPoint.add(turtle.y);
                    xPoint.add(turtle.x);
                }else if(input == 'B') {
                    turtle.backward();
                    yPoint.add(turtle.y);
                    xPoint.add(turtle.x);
                }else if(input == 'R') {
                    turtle.right();

                }else{
                    turtle.left();
                }
            }

            Collections.sort(yPoint);
            Collections.sort(xPoint);

            int height = Math.abs(yPoint.get(0) - yPoint.get(yPoint.size() - 1));
            int width = Math.abs(xPoint.get(0) - xPoint.get(xPoint.size() - 1));
            results.add(width*height);
            T--;
        }

        for (Integer result : results) {
            System.out.println(result);
        }
    }
}