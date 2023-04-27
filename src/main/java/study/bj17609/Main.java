package study.bj17609;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/jcr/Desktop/github/Algorithm/src/main/java/study/bj17609/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int count = Integer.parseInt(br.readLine());

        while(count-- != 0) {
            String[] strings = br.readLine().split("");

            int left = 0;
            int right = strings.length-1;

            int flag = 0;

            int changeCount = 0;
            flag = Math.min(getFlagLeft(strings, left, right, flag, changeCount), getFlagRight(strings, left, right, flag, changeCount));

            System.out.println(flag);
        }
    }

    private static int getFlagRight(String[] strings, int left, int right, int flag, int changeCount) {
        while(left < right) {
            if(strings[left].equals(strings[right])) {

            }else{
                //left+1
                if((right -1) >= 0 && (right -1) >= left && strings[left].equals(strings[right -1]) && changeCount == 0) {
                    right--;
                    changeCount++;
                    flag = 1;
                } else if((left +1) < strings.length && (left +1) <= right && strings[left +1].equals(strings[right]) && changeCount == 0) {
                    left++;
                    changeCount++;
                    flag = 1;
                }else {
                    flag =2;
                    break;
                }
            }

            left++;
            right--;
        }
        return flag;
    }

    private static int getFlagLeft(String[] strings, int left, int right, int flag, int changeCount) {
        while(left < right) {
            if(strings[left].equals(strings[right])) {

            }else{
                //left+1
                if((left +1) < strings.length && (left +1) <= right && strings[left +1].equals(
                    strings[right]) && changeCount == 0) {
                    left++;
                    changeCount++;
                    flag = 1;
                }else if((right -1) >= 0 && (right -1) >= left && strings[left].equals(
                    strings[right -1]) && changeCount == 0) {
                    right--;
                    changeCount++;
                    flag = 1;
                }else {
                    flag =2;
                    break;
                }
            }

            left++;
            right--;
        }
        return flag;
    }
}