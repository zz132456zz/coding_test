// SWEA 1240 - 단순 2진 암호코드

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class swea_1240 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();
        map.put("0001101", 0);
        map.put("0011001", 1);
        map.put("0010011", 2);
        map.put("0111101", 3);
        map.put("0100011", 4);
        map.put("0110001", 5);
        map.put("0101111", 6);
        map.put("0111011", 7);
        map.put("0110111", 8);
        map.put("0001011", 9);

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            String str = null;
            int lastIdx = 0;
            for (int i = 0; i < N; i++) {
                String temp = br.readLine();
                if (temp.contains("1")) {
                    str = temp;
                    lastIdx = temp.lastIndexOf("1");
                }
            }
            int sum = 0;
            int answer = 0;

            str = str.substring(lastIdx - 55, lastIdx + 1);

            for (int i = 0; i < 8; i++) {
                String temp = str.substring(i * 7, i * 7 + 7);
                if (i % 2 == 0) {
                    sum += map.get(temp) * 3;
                } else {
                    sum += map.get(temp);
                }
                answer += map.get(temp);
            }

            if (sum % 10 != 0) {
                answer = 0;
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
