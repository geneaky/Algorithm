package study.bj2800;

import java.util.*;
import java.io.*;

public class Main {

    static class Pair {
        int left;
        int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static List<Pair> pairs;
    static int pairCount;
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj2800/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Integer> stack = new Stack<>();
        set = new TreeSet<>();

        pairs = new ArrayList<>();

        int inputSize = input.length();
        for(int i = 0; i < inputSize; i++) {
            char cur = input.charAt(i);
            if(cur == '(') {
                stack.add(i);
            }else if(cur == ')') {
                pairs.add(new Pair(stack.pop(), i));
            }
        }
        pairCount = pairs.size();
        makeString(0, input+"");

        set.remove(input);

        StringBuilder answer = new StringBuilder();
        for (String s : set) {
            answer.append(s).append('\n');
        }
        System.out.println(answer);
    }

    private static void makeString(int idx, String str) {
        if(idx == pairCount) {
            set.add(str.replace(" ", ""));
            return;
        }

        Pair pair = pairs.get(idx);
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(pair.left, ' ');
        sb.setCharAt(pair.right, ' ');
        makeString(idx+1, sb.toString());
        makeString(idx + 1, str);
    }
}