package sds.day3.b1202;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1202AS {

    static int M, K;

    static Jewelry[] jewelries;
    static long[] bags;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/main/java/sds/day3/b1202/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jewelries = new Jewelry[M];
        bags = new long[K];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            jewelries[i] = new Jewelry(Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));
        }

        for(int j = 0; j < K; j++) {
            bags[j] = Long.parseLong(br.readLine());
        }

       //가방 오름 차순 정렬
        Arrays.sort(bags);
        //보석 무게 오름차순 정렬
        Arrays.sort(jewelries, Comparator.comparingInt(Jewelry::getWeight));
        //보석 가격이 높은 기준 힙
        PriorityQueue<Jewelry> pq = new PriorityQueue<>(
            Comparator.comparingInt(Jewelry::getValue).reversed());

        int jindex = 0;
        long result = 0;
        //1. 남은 가방 중 제일 작은 가방을 선택 < - 정렬
        for(int i = 0; i < bags.length; i++) {
           //2. 선택한 가방에 넣을 수 있는 남은 보석 중 가장 비싼 보석을 선택 < - 힙을 사용.
            while(jindex < M && jewelries[jindex].weight <= bags[i]) {
                pq.add(jewelries[jindex++]);
            }
            if(!pq.isEmpty()) {
                result += pq.poll().getValue();
            }
        }

        System.out.println(result);
    }

}

class Jewelry {
    int weight;
    int value;

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Jewelry{" +
            "weight=" + weight +
            ", value=" + value +
            '}';
    }

    public Jewelry(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}