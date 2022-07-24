package sds.day4.b9202;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int[] mx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] my = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] score = {0, 0, 0, 1, 1, 2, 3, 5, 11};
    static int w;
    static int b;

    static char[][] map;
    static boolean[][] visited;
    static String answer;
    static int sum;
    static int count;
    static StringBuilder sb;
    static Node root;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/main/java/sds/day4/b9202/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        w = Integer.parseInt(br.readLine());

        for(int i = 0; i < w; i++) {
            insertNode(br.readLine());
        }
        br.readLine();

        b = Integer.parseInt(br.readLine());
        StringBuilder resultSb = new StringBuilder();
        for(int n = 0; n < b; n++) {
            map = new char[4][4];
            visited = new boolean[4][4];
            answer = "";
            sum = 0;
            count = 0;
            sb = new StringBuilder();

            for(int i = 0; i < 4; i++) {
                String in = br.readLine();
                for(int k = 0; k < 4; k++) {
                    map[i][k] = in.charAt(k);
                }
                br.readLine();
                for (int y = 0; y < 4; y++) {
                    for (int x = 0; x < 4; x++) {
                        //출발 가능 조건 -> root가 해당 child를 가지면
                        if (root.hasChild(map[y][x])) {
                            search(y, x, root.getChild(map[y][x]));
                        }
                    }
                }
                //결과 출력
                root.clearHit();
            }

            System.out.println(resultSb.toString());
        }
    }

    private static void search(int y, int x, Node node) {
        //체크인
        visited[y][x] = true;
        sb.append(map[y][x]);
        //목적지인가? -> isWord, isHit
        if (node.isWord && !node.isHit) {
            node.isHit = true;
            //답 작업 -> 길이, 단어
            String findWord = sb.toString();
            int length = findWord.length();

        }
        //연결된 곳을 순회 -> 8방
        for(int i = 0; i < 8; i++) {
            int ty = y + my[i];
            int tx = x + mx[i];
        //가능한가? - map 경계, 방문하지 않았는지, node가 해당 자식을 가지고 있는지
            if(0 <= ty && ty < 4 && 0 <= tx && tx < 4){
                if (!visited[ty][tx] && node.hasChild(map[ty][tx])) {
                    //간다
                    search(ty, tx, node.getChild(map[ty][tx]));
                }
            }
        }
        //체크아웃
        visited[y][x] = false;
        sb.deleteCharAt(sb.length() - 1);
    }

    static void insertNode(String word) {
        Node current = root;
        for(int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            int index = a - 'A';
            if(current.child[index] == null) {
                current.child[index] = new Node();
            }
            current = current.child[index];
        }
        current.isWord = true;
    }

}

class Node {

    boolean isWord = false;
    boolean isHit = false;
    Node[] child = new Node[26];

    void clearHit() {
        isHit = false;
        for(int i = 0; i < child.length; i++) {
            if(child[i] != null) {
                child[i].clearHit();
            }
        }
    }

    boolean hasChild(char c) {
        return child[c - 'A'] != null;
    }

    Node getChild(char c) {
        return child[c - 'A'];
    }
}
