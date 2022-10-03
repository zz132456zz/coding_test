// SWEA 1928 - Base64 Decoder

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class swea_1928 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> map = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < 26; i++) {
            map.put((char) ('A' + i), idx++);
        }
        for (int i = 0; i < 26; i++) {
            map.put((char) ('a' + i), idx++);
        }
        for (int i = 0; i < 10; i++) {
            map.put((char) ('0' + i), idx++);
        }
        map.put('+', idx++);
        map.put('/', idx);

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            String str = br.readLine();
            int len = str.length() / 4 * 3;
            StringBuilder temp = new StringBuilder();
            String answer = "";

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                String binaryStr = Integer.toBinaryString(map.get(c));
                temp.append(String.format("%06d", Integer.parseInt(binaryStr)));
            }

            for (int i = 0; i < len; i++) {
                sb.append(Character.toChars(Integer.parseInt(temp.substring(i * 8, i * 8 + 8), 2)));
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }

}
