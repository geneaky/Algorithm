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

public class B1202 {

    static int M, K;

    static long[][] bosukList;
    static long[] bagList;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/main/java/sds/day3/b1202/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bosukList = new long[M][2];
        bagList = new long[K];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            bosukList[i][0] = Long.parseLong(st.nextToken());
            bosukList[i][1] = Long.parseLong(st.nextToken());

        }

        for(int j = 0; j < K; j++) {
            st = new StringTokenizer(br.readLine());
            bagList[j] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(bagList);
        Arrays.sort(bosukList, (o1, o2) -> (int) (o1[0] - o2[0]));
        Queue<Long> queue = new PriorityQueue<>(Collections.reverseOrder());

        int ret = 0;

        int pointBosuk = 0;
        int pointBag = 0;

        //비어있는 큐에서 꺼내면 안됨
        //보석의 무게가 가방의 용량보다 작거나 같을 때까지 큐에 넣음
        //보석의 무게가 가방의 용량을 넘어서는 시점에 큐에서 하나 꺼내서 결과값에 더한다 -> 이때 큐가 비어있으면 아무것도 못 꺼내는거지
        //보석의 무게가 가방의 용량을 넘어서는 시점에 다음 가방으로 변경해야함
        //보석을 전부 큐에 넣었는데 가방의 인덱스가 아직 끝까지 안갔으면 순회돌면서 하나씩 꺼내는데  -> 이때 큐가 비어있으면 아무것도 못 꺼내는거지
        while(pointBosuk < M) {
            if (bosukList[pointBosuk][0] <= bagList[pointBag]) {
                queue.offer(bosukList[pointBosuk][1]);
            }else{
                if(!queue.isEmpty()) {
                    ret += queue.poll();
                }
                pointBag++;
            }
            pointBosuk++;
        }

        for(int i = pointBag; i < K; i++) {
            if(!queue.isEmpty()) {
                ret += queue.poll();
            }
        }
        System.out.println(ret);

    }

}
