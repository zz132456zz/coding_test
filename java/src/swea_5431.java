// SWEA 5431 - 민석이의 과제 체크하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5431 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            boolean[] checked = new boolean[N + 1];
            for (int i = 0; i < K; i++) {
                int n = Integer.parseInt(st.nextToken());
                checked[n] = true;
            }

            sb.append("#").append(tc);
            for (int i = 1; i <= N; i++) {
                if (!checked[i]) {
                    sb.append(" ").append(i);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

}
