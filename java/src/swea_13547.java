// SWEA 13547 - 팔씨름

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_13547 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String S = br.readLine();
            int k = S.length();
            int cnt = 0;

            for (int i = 0; i < k; i++) {
                if (S.charAt(i) == 'o') {
                    cnt++;
                }
            }

            cnt += 15 - k;

            sb.append("#").append(tc).append(" ");
            if (cnt >= 8) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
