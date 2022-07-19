package sds.day1.b1062;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B1062AS {

    static int N, K;
    static String[] words;
    static int max = 0;

    static boolean[] visited;
    static int selectedCount = 0;

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("src/main/java/sds/day1/b1062/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        K = sc.nextInt();

        words = new String[N];
        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;

        for(int i = 0; i < N; i++) {
            words[i] = sc.next().replaceAll("[antic]","");
        }

        selectedCount = 5;
        max = countWords();

        for(int i = 0; i < 26; i++) {
            if(visited[i] == false) {
                dfs(i);
            }
        }
        System.out.println(max);
    }

    private static void dfs(int index) {
        //1. 체크인
        visited[index] = true;
        selectedCount++;
        //2. 목적지인가? : selectedCount -- K => 읽을 수 있는 단어 개수 계산
        if(selectedCount == K) {
            max = Math.max(max, countWords());
        }else {
            //3. 연결됫 곳을 순회 : index+1 ~ 25
            for(int i = index + 1; i <= 25; i++) {
                //4. 갈 수 있는가? : 방문 여부
                if (!visited[i]) {
                    //5. 간다 : dfs()
                    dfs(i);
                }
            }
        }
        
        //6. 체크 아웃
        visited[index] = false;
        selectedCount--;

    }

    static int countWords() {
        int count = 0;
        
        for(int n = 0; n < N; n++) {
            boolean isPossible = true;
            String word = words[n];
            
            for(int i = 0; i < word.length(); i++) {
                if(!visited[word.charAt(i) - 'a']) {
                    isPossible = false;
                    break;
                }
            }

            if(isPossible) {
                count++;
            }
        }
        return count;
    }
}
