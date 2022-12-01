// SWEA 11856 - 반반

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class swea_11856 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String S = br.readLine();

            Map<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < 4; i++) {
                char c = S.charAt(i);

                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }

            sb.append("#").append(tc).append(" ");

            if (map.size() == 2) {
                for (char c : map.keySet()) {
                    if (map.get(c) != 2) {
                        sb.append("No");
                        break;
                    }
                }
                sb.append("Yes");
            } else {
                sb.append("No");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }

}
