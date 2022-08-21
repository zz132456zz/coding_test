// 프로그래머스 118666 - 성격 유형 검사하기

import java.util.HashMap;
import java.util.Map;

public class programmers_118666 {

    public static String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();

        int N = survey.length;
        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);

        for (int i = 0; i < N; i++) {
            if (choices[i] < 4) {
                char cur = survey[i].charAt(0);
                map.put(cur, map.get(cur) + 4 - choices[i]);
            } else if (choices[i] > 4) {
                char cur = survey[i].charAt(1);
                map.put(cur, map.get(cur) + choices[i] - 4);
            }
        }

        if (map.get('R') < map.get('T')) answer.append('T');
        else answer.append('R');
        if (map.get('C') < map.get('F')) answer.append('F');
        else answer.append('C');
        if (map.get('J') < map.get('M')) answer.append('M');
        else answer.append('J');
        if (map.get('A') < map.get('N')) answer.append('N');
        else answer.append('A');

        return answer.toString();
    }

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        String result = solution(survey, choices);

        System.out.println(result);
    }

}
