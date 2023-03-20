package study.bj1347;

import java.util.*;
import java.io.*;

public class Main {

    public static class Node {

        int y;
        int x;
        int direction; // {1,2,3,4} 서북동남

        public Node(int y, int x, int direction) {
            this.y = y;
            this.x = x;
            this.direction = direction;
        }

        public void go() {
            if(direction == 1) {
                x--;
            }else if(direction == 2) {
                y--;
            }else if(direction == 3) {
                x++;
            }else{
                y++;
            }
        }

        public void left() {
            if(direction - 1 == 0) direction = 4;
            else direction--;
        }

        public void right() {
            if(direction + 1 == 5) direction = 1;
            else direction++;
        }

        public int[] next() {
            if(direction == 1) {
                return new int[]{y, x-1};
            }else if(direction == 2) {
                return new int[]{y-1, x};
            }else if(direction == 3) {
                return new int[]{y,x+1};
            }else{
                return new int[]{y+1, x};
            }
        }
    }

    public static class Location {
        int y;
        int x;
        String flag;

        public Location(int y, int x, String flag) {
            this.y = y;
            this.x = x;
            this.flag = flag;
        }
    }


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1347/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        String[] split = br.readLine().split("");

        // (0,0) 남쪽 방향 보면서 스타트
        Node node = new Node(0, 0, 4);

        List<Integer> yloc = new ArrayList<>();
        List<Integer> xloc = new ArrayList<>();
        List<Location> locations = new ArrayList<>();
        yloc.add(node.y);
        xloc.add(node.x);
        locations.add(new Location(node.y, node.x, "."));

        for (String s : split) {
            if(s.equals("R")) {
                int[] next = node.next();
                yloc.add(next[0]);
                xloc.add(next[1]);
                locations.add(new Location(next[0], next[1], "#"));
                node.right();
            }else if(s.equals("L")) {
                int[] next = node.next();
                yloc.add(next[0]);
                xloc.add(next[1]);
                locations.add(new Location(next[0], next[1], "#"));
                node.left();
            }else {
                node.go();
                yloc.add(node.y);
                xloc.add(node.x);
                locations.add(new Location(node.y, node.x, "."));
            }
        }

        Collections.sort(yloc);
        Collections.sort(xloc);

        int minY = yloc.get(0);
        int maxY = yloc.get(yloc.size() - 1);
        int minX = xloc.get(0);
        int maxX = xloc.get(xloc.size() - 1);

        int ylength = Math.abs(maxY - minY) + 1;
        int xlength = Math.abs(maxX - minX) + 1;

        String[][] result = new String[ylength][xlength];

        for(int i = 0; i < ylength; i++){
            for(int j = 0; j < xlength; j++){
                result[i][j] = "#";
            }
        }

        for(Location location : locations) {
            int y = minY < 0 ? location.y + Math.abs(minY) : location.y;
            int x = minX < 0 ? location.x + Math.abs(minX) : location.x;
            if(result[y][x].equals(".")) continue;
            result[y][x] = location.flag;
        }

        Set<String> set = new HashSet<>();

        int ystart = 0;
        for(int i = 0; i < xlength; i++) {
            set.add(result[0][i]);
        }
        if(set.size() == 1 && set.contains("#")) ystart = 1;
        set.clear();

        int yend = 0;
        for(int i = 0; i < xlength; i++) {
            set.add(result[ylength-1][i]);
        }
        if(set.size() == 1 && set.contains("#")) yend = 1;
        set.clear();

        int xstart = 0;
        for(int i = 0; i < ylength; i++) {
            set.add(result[i][0]);
        }
        if(set.size() == 1 && set.contains("#")) xstart = 1;
        set.clear();
        int xend = 0;
        for(int i = 0; i < ylength; i++) {
            set.add(result[i][xlength-1]);
        }
        if(set.size() == 1 && set.contains("#")) xend = 1;

        for(int i = 0 + ystart; i < ylength - yend; i++) {
            for(int j = 0 + xstart; j < xlength - xend; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}