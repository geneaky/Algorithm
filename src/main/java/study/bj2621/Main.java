package study.bj2621;

import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<CARD> list;
    static ArrayList<String> COLOR;
    static ArrayList<Integer> NUMBER;
    static int NO[];
    static int ANSWER,MAX;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ANSWER = Integer.MIN_VALUE;
        MAX = Integer.MIN_VALUE;
        list = new ArrayList<>();
        COLOR = new ArrayList<>();
        NUMBER = new ArrayList<>();
        NO = new int[10];

        // 1.카드 정보 입력
        for (int i = 0; i < 5; i++) {
            String c = sc.next();
            int n = sc.nextInt();

            list.add(new CARD(c, n));
        }

        // 2. 정렬
        Collections.sort(list);

        //printList();


        // 3. 숫자, 색상 갯수 세기
        for(int i=0; i<5; i++) {
            CARD chk = list.get(i);

            //숫자 몇개 동일한지
            NO[chk.no] += 1;

            //게임 카드 숫자 MAX확인
            MAX = Math.max(MAX, chk.no);

            //숫자 체크
            if(!NUMBER.contains(chk.no))
                NUMBER.add(chk.no);

            //색 체크
            if(!COLOR.contains(chk.color))
                COLOR.add(chk.color);
        }

        //4.조건 1~9까지 해당하는 부분 어딘지 체크
        // 1) 조건4 : 모두 같은색인가??
        if(COLOR.size()==1) {
            ANSWER = Math.max(ANSWER, (MAX+600));
        }

        if(NUMBER.size()==5) {
            int n=Math.abs(NUMBER.get(0)-NUMBER.get(4));

            // 2) 조건1 : 모두 같은 색이면서 숫자 연속적인가?
            if(n==4 && COLOR.size()==1) {
                ANSWER = Math.max(ANSWER, (MAX+900));
            }

            // 3) 조건 5. 숫자 5장 연속적
            if(n==4) {
                ANSWER = Math.max(ANSWER, (MAX+500));
            }
        }

        if(NUMBER.size()==2) {
            // 4) 조건2. 숫자카드 4장 동일
            if(NO[NUMBER.get(0)]==4) {
                ANSWER = Math.max(ANSWER, (NUMBER.get(0)+800));
            }else if(NO[NUMBER.get(1)]==4) {
                ANSWER = Math.max(ANSWER, (NUMBER.get(1)+800));
            }

            // 5) 조건3. 숫자카드 3장,2장 동일
            if(NO[NUMBER.get(0)]==3 && NO[NUMBER.get(1)]==2) {
                ANSWER = Math.max(ANSWER, ((NUMBER.get(0)*10)+NUMBER.get(1)+700));
            }else if(NO[NUMBER.get(0)]==2 && NO[NUMBER.get(1)]==3) {
                ANSWER = Math.max(ANSWER, ((NUMBER.get(1)*10)+NUMBER.get(0)+700));
            }
        }else if(NUMBER.size()==3) {
            // 6) 조건6. 숫자3장 동일
            if(NO[NUMBER.get(0)]==3) {
                ANSWER = Math.max(ANSWER, (NUMBER.get(0)+400));
            }else if(NO[NUMBER.get(1)]==3) {
                ANSWER = Math.max(ANSWER, (NUMBER.get(1)+400));
            }else if(NO[NUMBER.get(2)]==3) {
                ANSWER = Math.max(ANSWER, (NUMBER.get(2)+400));
            }

            // 7) 조건7. 숫자 2장, 2장 동일
            if(NO[NUMBER.get(0)]==2 && NO[NUMBER.get(1)]==2) {
                ANSWER=Math.max(ANSWER, ((NUMBER.get(1)*10)+NUMBER.get(0)+300));
            }else if(NO[NUMBER.get(0)]==2 && NO[NUMBER.get(2)]==2) {
                ANSWER=Math.max(ANSWER, ((NUMBER.get(2)*10)+NUMBER.get(0)+300));
            }else if(NO[NUMBER.get(1)]==2 && NO[NUMBER.get(2)]==2) {
                ANSWER=Math.max(ANSWER, ((NUMBER.get(2)*10)+NUMBER.get(1)+300));
            }

        }else if(NUMBER.size()==4) {
            for(int i=0; i<NUMBER.size(); i++) {
                if(NO[NUMBER.get(i)]==2) {
                    ANSWER=Math.max(ANSWER, ((NUMBER.get(i)+200)));
                    break;
                }
            }
        }


        //9) 조건 9: 아무조건도 해당 되지 않는 경우
        if(ANSWER==Integer.MIN_VALUE) {
            ANSWER = MAX +100;
        }

        System.out.println(ANSWER);
    }

    private static void printList() {
        for(int i=0; i<list.size();i++) {
            CARD c1 = list.get(i);
            System.out.println(c1.color+", "+c1.no);
        }
    }
}

class CARD implements Comparable<CARD> {
    String color;
    int no;

    CARD(String color, int no) {
        this.color = color;
        this.no = no;
    }


    @Override
    public int compareTo(CARD c) {
        return (this.no-c.no);
    }
}