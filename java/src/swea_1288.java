// SWEA 1288 - 새로운 불면증 치료법

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class swea_1288 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int answer = 0;
            Set<Character> set = new HashSet<>();

            int idx = 1;
            while (set.size() != 10) {
                int temp = N * idx++;

                for (char c : Integer.toString(temp).toCharArray()) {
                    set.add(c);
                }

                answer++;
            }

            sb.append("#").append(tc).append(" ").append(answer * N).append("\n");
        }

        System.out.print(sb);
    }

}
