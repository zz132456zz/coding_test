// 프로그래머스 84512 - 모음사전

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class programmers_84512 {

    static char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    static List<String> wordList = new ArrayList<>();
    
    public static int solution(String word) {
        for (int i = 1; i <= 5; i++) {
            makeWord(i, 0, new StringBuilder());
        }

        Collections.sort(wordList);

        int answer = wordList.indexOf(word) + 1;

        return answer;
    }
    
    public static void makeWord(int n, int depth, StringBuilder sb) {
        if (depth == n) {
            wordList.add(sb.toString());
            return;
        }

        for (int i = 0; i < 5; i++) {
            sb.append(alphabet[i]);
            makeWord(n, depth + 1, sb);
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String word = "AAAAE";
        int result = solution(word);

        System.out.println(result);
    }

}
