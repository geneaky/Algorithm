package sds.day3.b2243;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long[][] ABC;
    static int S;
    static long[] tree;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/main/java/sds/day3/b2243/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        ABC = new long[n][3];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ABC[i][0] = Long.parseLong(st.nextToken());
            ABC[i][1] = Long.parseLong(st.nextToken());
            if(ABC[i][0] == 1) {
                continue;
            }
            ABC[i][2] = Long.parseLong(st.nextToken());
        }

        //S를 찾고
        S = 1;
        while(S < 1000000) {
            S *= 2;
        }

        //트리 공간을 만들고
        tree = new long[S*2];

        //빈 사탕 상자에서 시작 > 텅빈 노드로 트리 초기화 없어도됨

        //입력 조건에 따른 A = 1, A = 2 연산 시작
        for(int i = 0; i < ABC.length; i++) {
            // A가 1이면 값을 꺼내고 출력 (한 개만 꺼낼 수 있음 -> 꺼내기때문에 qeury , update 둘 다 해줘야함)
            if(ABC[i][0] == 1) {
                long result = query(1,1000000, 1, ABC[i][1], ABC[i][1]);
                System.out.println(result);
                update(1,1000000, 1, ABC[i][1], ABC[i][1]);
            }else{
                // A가 2이면 값을 변경
                update(1,1000000, 1, ABC[i][1], ABC[i][1]);
            }
        }
    }

    private static long query(int left, int right, int node, long queryLeft, long queryRight) {
        //연관없음
        if(queryRight < left && right < queryLeft) {
            return 0;
        }else if(queryLeft <= left && right <= queryRight) {
        //판단가능
            return tree[node];
        }else{
            //판단불가 -> 자식 노드에 위임
            int mid = (left + right) / 2;
            long leftResult = query(left, mid-1, node, queryLeft, queryRight);
            long rightResult = query(mid + 1, right, node, queryLeft, queryRight);

            return leftResult + rightResult;
        }
    }
    private static void update(int left, int right, int node, long target, long diff) {
        //연관없음
        if(target < left || right < target) {
            return;
        }else {
            //연관있음 -> diff 반영 -> 자식 노드
            tree[node] += diff;
            int mid = (left + right) / 2;

            update(left, mid-1, node*2, target, diff);
            update(mid+1,right, node*2+1, target, diff);
        }
    }


}
