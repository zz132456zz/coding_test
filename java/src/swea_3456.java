// SWEA 3456 - 직사각형 길이 찾기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class swea_3456 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            Map<Integer, Integer> map = new HashMap<>();
            map.put(a, 1);
            if (map.containsKey(b)) {
                map.put(b, 2);
            } else {
                map.put(b, 1);
            }
            if (map.containsKey(c)) {
                map.put(c, 2);
            } else {
                map.put(c, 1);
            }

            if (map.size() == 1) {
                for (int k : map.keySet()) {
                    answer = k;
                }
            } else {
                for (int k : map.keySet()) {
                    if (map.get(k) == 1) {
                        answer = k;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
