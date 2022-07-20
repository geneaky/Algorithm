package sds.day2.b1713;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class B1713AS {

    public static class Nominee implements Comparable<Nominee>{
        int num;
        int count;
        int timeStamp;
        boolean isIn;

        public Nominee(int num, int count, int timeStamp, boolean isIn) {
            this.num = num;
            this.count = count;
            this.timeStamp = timeStamp;
            this.isIn = isIn;
        }

        @Override
        public String toString() {
            return "Nominee{" +
                "num=" + num +
                ", count=" + count +
                ", timeStamp=" + timeStamp +
                ", isIn=" + isIn +
                '}';
        }

        @Override
        public int compareTo(Nominee o) {
            int comp = Integer.compare(count, o.count);
            if(comp == 0) {
                return Integer.compare(timeStamp, o.timeStamp);
            }
            return comp;
        }
    }
    static int N;
    static int C;

    static Nominee[] nominees;

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("src/main/java/sds/day2/b1713/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        C = sc.nextInt();

        nominees = new Nominee[101];

        List<Nominee> list = new ArrayList<>();

        for(int i = 0; i < C; i++) {
            int num = sc.nextInt();
            //해당 후보가 최초 호출 시
            if(nominees[num] == null) {
                nominees[num] = new Nominee(num,0,0,false);
            }
            //해당 후보가 사진틀에 있을 경우
            if(nominees[num].isIn) {
                nominees[num].count++;
            }else{
                //해당 후보가 사진 틀에 없음
                //사진틀이 가득 찬 경우
                if(list.size() == N) {
                    //정렬, 지울 후보 선정, 제거
                    Collections.sort(list);
                    Nominee nomi = list.remove(0);
                    nomi.isIn = false;
                }
                //사진틀이 여유가 있는경우
                nominees[num].count = 1;
                nominees[num].isIn = true;
                nominees[num].timeStamp = i;
                list.add(nominees[num]);
            }

        }

        Collections.sort(list, Comparator.comparingInt(o -> o.num));

        for (Nominee nominee : list) {
            System.out.println(nominee.num);
        }
    }

}
