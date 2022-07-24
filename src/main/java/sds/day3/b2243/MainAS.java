package sds.day3.b2243;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainAS {

    static int N, M;
    static int A, B, C;
    static int MAX = 1000000;
    static int[] tree;
    static int S;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/main/java/sds/day3/b2243/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = 1;
        while(S < MAX) {
            S *= 2;
        }
        tree = new int[S*2];
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            if (A == 2) {
                B = Integer.parseInt(st.nextToken());
                C = Integer.parseInt(st.nextToken());
                update(1, S, 1, B, C);
            }else if(A == 1) {
                B = Integer.parseInt(st.nextToken());
                int index = query(1, S, 1, B);
                update(1, S, 1, index, -1);
                System.out.println(index);
            }
        }
    }

    private static void update(int left, int right, int node, int index, int diff) {
        if(left <= index && index <= right) {
            tree[node] += diff;
            if(left != right) {
                int mid = (left + right) / 2;
                update(left, mid, node * 2, index, diff);
                update(mid+1, right, node * 2 + 1, index, diff);
            }
        }
    }

    private static int query(int left, int right, int node, int count) {
        //1. leaf에 도착했을 때 -> 사탕, 번호 반환
        if(left == right) {
            return left;
        }
        else {
            int mid = (left + right) / 2;
        //2. 왼쪽 >= count -> 왼쪽으로 이동
            if(tree[node * 2] >= count) {
                return query(left, mid, node * 2, count);
            }else{
        //3. 왼쪽 < count -> 오른쪽으로 이동
                count -= tree[node * 2];
                return query(mid + 1, right, node * 2, count);
            }
        }
    }

}
