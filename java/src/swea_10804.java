// SWEA 10804 - 문자열의 거울상

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class swea_10804 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<Character, Character> map = new HashMap<>();
        map.put('b', 'd');
        map.put('d', 'b');
        map.put('p', 'q');
        map.put('q', 'p');

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String data = br.readLine();
            StringBuilder answer = new StringBuilder();

            for (int i = data.length() - 1; i >= 0; i--) {
                answer.append(map.get(data.charAt(i)));
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
