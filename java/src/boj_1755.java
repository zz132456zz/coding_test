// 백준 1755 - 숫자놀이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_1755 {

    // 각 숫자에 해당하는 단어
    static String[] numToString = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        List<String> stringList = new ArrayList<>();  // 문자열만 넣을 리스트
        Map<String, Integer> map = new HashMap<>();  // 문자열과 숫자를 넣을 map

        for (int i = M; i <= N; i++) {  // M부터 N까지
            String temp = intToString(i);  // 숫자를 문자열로 바꾼다
            stringList.add(temp);  // 리스트에 문자열만 추가
            map.put(temp, i);  // map에 문자열과 숫자를 맵핑하여 추가
        }

        Collections.sort(stringList);  // 문자열 리스트를 정렬

        for (int i = 0; i < stringList.size(); i++) {  // 정렬된 순서대로 확인
            sb.append(map.get(stringList.get(i)));  // 확인할 문자열에 해당하는 숫자를 결과 sb에 넣어준다.

            if (i % 10 == 9) {
                sb.append("\n");  // 10번째마다 줄바꿈
            } else {
                sb.append(" ");  // 10번째가 아니면 한칸띄우기
            }
        }

        System.out.println(sb);  // 결과 출력
    }

    public static String intToString(int num) {
        if (num < 10) {  // 10보다 작으면 그냥 해당 숫자를 단어로 바꿔서 리턴
            return numToString[num];
        } else {  // 10이상이면 10의 자리수를 바꾸고 1의 자리수를 바꿔서 합쳐서 리턴
            return numToString[num / 10] + " " + numToString[num % 10];
        }
    }

}
