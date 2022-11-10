// SWEA 7102 - 준홍이의 카드놀이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_7102 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] cnt = new int[41];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    cnt[i + j]++;
                }
            }

            int max = 0;
            for (int i = 0; i < 41; i++) {
                max = Math.max(max, cnt[i]);
            }

            sb.append("#").append(tc);
            for (int i = 0; i < 41; i++) {
                if (cnt[i] == max) sb.append(" ").append(i);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

}
