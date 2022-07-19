package sds.day1.b1062;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class B1062 {

    static int N, K;
    static String[] words;
    static int ret;

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("src/main/java/sds/day1/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        K = sc.nextInt();

        Map<String, Integer> map = new HashMap<>();
        String[] fixedString = {"a", "c", "i", "n", "t"};
        for(String s : fixedString) {
            map.put(s,1);
        }

        words = new String[N];

        for(int i = 0; i < N; i++) {
            words[i] = sc.next();
        }

        if(K <= fixedString.length) {
            System.out.println(0);
            return;
        }
        dfs(map,'a');

        System.out.println(ret);

    }

    private static void dfs(Map<String,Integer> map, char idx) {
        //1. 체크인
        //2. 목적지인가?
        //3. 연결됫 곳을 순회
        //4. 갈 수 있는가?
        //5. 간다
        //6. 체크 아웃
        if(K == map.size()) {
            int tempRet = 0;
            for(String word : words) {
                boolean flag = true;
                for(String s : word.split("")) {
                    if(!map.containsKey(s)) {
                        flag = false;
                    }
                }

                if(flag) {
                    tempRet++;
                }
            }
            ret = Math.max(ret, tempRet);
            return;
        }

        for(char i = idx; i < 'z'; i++) {
            if(map.containsKey(Character.toString(i))) {
                continue;
            }else {
                map.put(Character.toString(i), 1);
                dfs(map,idx++);
                map.remove(Character.toString(i));
            }
        }
    }

}
