package study.bj2108;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj2108/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        List<Integer> inputs = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            inputs.add(Integer.valueOf(br.readLine()));
        }

        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;

        for (Integer input : inputs) {
            one += input;
        }

        one = (int)Math.round((double)one / N);

        Collections.sort(inputs);

        two = inputs.get(N/2);

        Map<Integer, Integer> map = new HashMap<>();
        for (Integer integer : inputs) {
            map.put(integer, map.getOrDefault(integer, 0) + 1);
        }

        int count = 0;
        for (Integer integer : map.keySet()) {
            if(map.get(integer) > count) {
                count = map.get(integer);
            }
        }

        List<Integer> temp = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            if(map.get(integer) == count) {
                temp.add(integer);
            }
        }

        Collections.sort(temp);
        if(temp.size() >= 2) {
            three = temp.get(1);
        }else{
            three = temp.get(0);
        }

        if(N == 1) {
            four = 0;
        }else{
            four = inputs.get(inputs.size()-1) - inputs.get(0);
        }

        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
        System.out.println(four);
    }
}