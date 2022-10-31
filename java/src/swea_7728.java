// SWEA 7728 - 다양성 측정

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_7728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String X = br.readLine();
            int answer = 0;
            int[] cnt = new int[10];

            for (int i = 0; i < X.length(); i++) {
                cnt[X.charAt(i) - '0']++;
            }

            for (int i = 0; i < 10; i++) {
                if (cnt[i] != 0) answer++;
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
