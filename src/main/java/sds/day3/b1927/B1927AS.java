package sds.day3.b1927;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1927AS {

    static int N;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/main/java/sds/day3/b1927/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        MinHeap mh = new MinHeap();

        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                System.out.println(mh.delete());
            }else{
                mh.insert(input);
            }
        }

    }

}

class MinHeap {
    List<Integer> list;

    public MinHeap() {
        list = new ArrayList<>();
        list.add(0);
    }

    public void insert(int val) {
        //1. leaf 마지막에 삽입
        list.add(val);
        //2. 부모와 비교 후 조건에 맞지 않으면 swap
        //3. 조건이 만족되거나 root까지 반복
        int current = list.size() - 1;
        int parent = current / 2;
        while(true) {
            if(parent == 0 || list.get(parent) <= list.get(current)) {
                break;
            }

            int temp = list.get(parent);
            list.set(parent, list.get(current));
            list.set(current, temp);

            current = parent;
            parent = current / 2;
        }
    }

    public int delete() {
        if(list.size() == 1) {
            return 0;
        }

        //1. root에 leaf 마지막 데이터 가져옴
        int top = list.get(1);
        list.set(1, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        //2. 자식과 비교 후 조건에 맞지 않으면 swap
        //3. 조건의 만족되거나 leaf까지 반복
        int current = 1;
        while(true) {
            int leftPos = current * 2;
            int rightPos = current * 2 + 1;
            //왼쪽 자식 먼저 확인
            if (leftPos >= list.size()) {
                break;
            }

            int minValue = list.get(leftPos);
            int minPos = leftPos;

            //오른쪽 자식 확인
            if (rightPos < list.size() && minValue > list.get(rightPos)) {
                minValue = list.get(rightPos);
                minPos = rightPos;
            }

            //swap
            if (list.get(current) > minValue) {
                int temp = list.get(current);
                list.set(current, minValue);
                list.set(minPos, temp);
                current = minPos;
            }
        }

        return top;
    }
}
