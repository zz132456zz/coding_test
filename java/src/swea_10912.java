// SWEA 10912 - 외로운 문자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_10912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String str = br.readLine();
            StringBuilder answer = new StringBuilder();

            int[] cnt = new int[26];
            for (int i = 0; i < str.length(); i++) {
                int idx = str.charAt(i) - 'a';
                cnt[idx]++;
            }

            for (int i = 0; i < 26; i++) {
                if (cnt[i] % 2 != 0) {
                    answer.append((char) ('a' + i));
                }
            }

            if (answer.length() == 0) {
                answer.append("Good");
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
