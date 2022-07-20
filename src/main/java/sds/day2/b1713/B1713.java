package sds.day2.b1713;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class B1713 {

    public static class Student {
        int studentNumber;
        int recommended;
        int recommendedAt;

        public Student(int studentNumber, int recommended, int recommendedAt) {
            this.studentNumber = studentNumber;
            this.recommended = recommended;
            this.recommendedAt = recommendedAt;
        }

        public int getStudentNumber() {
            return studentNumber;
        }
    }
    static int N;
    static int C;

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("src/main/java/sds/day2/b1713/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        C = sc.nextInt();

        List<Student> list = new ArrayList<>();
        //추천전 사진틀은 모두 비어 있다.

        for(int i = 0; i < C; i++) {
            int studentNumber = sc.nextInt();
            boolean flag = false;
            //(공통) : 현재 사진틀에 게시된 학생이 추천된 경우 추천 수만 증가
            for(int t = 0; t <list.size(); t++) {
                if(list.get(t).studentNumber == studentNumber) {
                    list.get(t).recommended++;
                    flag = true;
                }
            }
            if(flag) continue;

            if(list.size() >= N) {
                int idx = 0;
                int temp = list.get(0).recommended;
                for(int t = 0; t <list.size(); t++) {
                    //비어있는 사진틀이 없는 경우 현재까지 추천 받은 횟수가 가장 적은 사진틀에서 사진 삭제하고 그! 자리에! 새롭게 추천 받은 학생 사진 게시
                    if(list.get(t).recommended < temp) {
                        idx = t;
                        temp = list.get(t).recommended;
                    //현재까지 추천 받은 횟수가 가장 적은 학생의 수가 두 명 이상인 경우 사진틀에 게시된지 가장 오래된 사진을 삭제
                    }else if(list.get(t).recommended == temp) {
                        if(list.get(t).recommendedAt > temp) {
                            idx = t;
                            temp = list.get(t).recommended;
                        }
                    }
                }
                //사진틀에 게시된 사진이 삭제된 경우 해당 학생의 추천수는 0이
                list.remove(idx);
                list.add(idx, new Student(studentNumber, 1, 0));
            }else{
                //추천하면 사진틀에 사진이 게시 되어야 한다
                list.add(new Student(studentNumber, 1, 0));
            }
            //사진틀에 게시 되면 이후로 시간이 계속 증가해야함
            for(int t = 0; t < list.size(); t++){
                list.get(t).recommendedAt++;
            }
        }

        //최종 후보 출력은 학생번호가 증가하는 순서로 출력
        Comparator<Student> studentComparator = Comparator.comparingInt(Student::getStudentNumber);
        Collections.sort(list, studentComparator);

        for (Student student : list) {
            System.out.println(student.studentNumber);
        }


    }

}
