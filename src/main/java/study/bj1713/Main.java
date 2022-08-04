package study.bj1713;

import java.util.*;
import java.io.*;
import org.w3c.dom.ls.LSOutput;

public class Main {

    static int N, VOTE_COUNT;

    static Student[] students;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj1713/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        VOTE_COUNT = Integer.parseInt(br.readLine());

        students = new Student[101];

        List<Student> list = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < VOTE_COUNT; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(students[num] == null) {
                students[num] = new Student(0, 0, num, false);
            }

            if(students[num].isIn){
                students[num].recommend++;
            }else{
                if(list.size() == N) {
                    Collections.sort(list);
                    Student student = list.remove(0);
                    student.isIn = false;
                }
                students[num].isIn = true;
                students[num].time = i;
                students[num].recommend = 1;
                list.add(students[num]);
            }
        }

        Collections.sort(list,Comparator.comparingInt(Student::getSnum));
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).snum);
            if(i == list.size() -1 ) {
                break;
            } else {
                System.out.print(" ");
            }
        }
    }
}

class Student implements Comparable<Student>{
    int time;
    int recommend;
    int snum;

    boolean isIn;

    public Student(int time, int recommend, int snum, boolean isIn) {
        this.time = time;
        this.recommend = recommend;
        this.snum = snum;
        this.isIn = isIn;
    }

    public int getTime() {
        return time;
    }

    public int getRecommend() {
        return recommend;
    }

    public int getSnum() {
        return snum;
    }

    @Override
    public int compareTo(Student o) {
        int comp = Integer.compare(recommend, o.recommend);
        if(comp == 0) {
            return Integer.compare(time, o.time);
        }
        return comp;
    }
}