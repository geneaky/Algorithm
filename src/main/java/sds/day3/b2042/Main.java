package sds.day3.b2042;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;

    static int[] list;

    static int[][] conditions;

    static int S;
    static int[] tree;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/main/java/sds/day3/b2042/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new int[N];

        for(int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        conditions = new int[M + K][3];

        for(int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            conditions[i][0] = Integer.parseInt(st.nextToken());
            conditions[i][1] = Integer.parseInt(st.nextToken());
            conditions[i][2] = Integer.parseInt(st.nextToken());
        }

        S = 1;

        while(S < N) {
            S *= 2;
        }

        tree = new int[S * 2];
        init();

        for(int i = 0; i < conditions.length; i++) {
            if(conditions[i][0] == 1) {
                update(1, N, 1, list[conditions[i][1]-1],  list[conditions[i][2]-1]-list[conditions[i][1]-1]);
            }else{
                query(1, N, 1, list[conditions[i][1]-1], list[conditions[i][2]-1]);
            }
        }

    }

    private static void init() {

        //리프 노드 초기화
        for(int i = 0; i < N; i++) {
            tree[S + i] = list[i];
        }

        for(int i = S - 1; i > 0; i--) {
            tree[i] = tree[i*2] + tree[i*2+1];
        }
    }

    private static int query(int left, int right, int node, int queryLeft, int queryRight) {
        //연관이 없음 -> 결과에 영향이 없는 값 return
        if(queryRight < left || right < queryLeft) {
            return 0;
        }
        //판단 가능 -> 현재 노드 값 return
        else if(queryLeft <= left && right <= queryRight) {
            return tree[node];
        }
        //판단불가, 자식에게 위임, 자식에서 올라온 합을 return
        else{
            int mid = (left + right) / 2;
            int resultLeft = query(left, mid, node * 2, queryLeft, queryRight);
            int resultRight = query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);

            return resultLeft + resultRight;
        }
    }

    private static void update(int left, int right, int node, int target, int diff) {
        //연관없음
        if(target < left || right < target){
            return;
        }
        //연관있음 -> 현재 노드에 diff 반영 -> 자식에게 diff 전달
        else {
            tree[node] += diff;
            if(left != right) {
                int mid = (left + right) / 2;
                update(left, mid, node * 2, target, diff);
                update(mid+1, right, node * 2 + 1, target, diff);
            }
        }
    }

    private static int queryBU(int queryLeft, int queryRight) {
        // Left 에서 left, right 설정
        int left = S + queryLeft - 1;
        int right = S + queryRight - 1;
        int sum = 0;
        while(left <= right) { // == 은 구간이 하나일 때
            //좌측 경계가 홀수이면 현재 노드 값 사용하고 한칸 옆으로
            if(left % 2 == 1) {
                sum += tree[left++];
            }
            //우측 경계가 짝수이면 현재 노드 값 사용하고 한칸 옆으로
            if(right % 2 == 0) {
                sum += tree[right--];
            }
            //좌측,우측 모두 부모로 이동
            left /= 2;
            right /= 2;
        }

        return sum;
    }

    private static void updateBU(int target, int value) {
        //leaf에서 target을 찾음
        int node = S + target - 1;
        //value 반영
        tree[node] = value;
        //root에 도달할 때 까지 부모에 값 반영
        node /= 2;
        while(node > 0) {
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
            node /= 2;
        }
    }
}
