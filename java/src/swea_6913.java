// SWEA 6913 - 동철이의 프로그래밍 대회

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_6913 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] data = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                int score = 0;
                for (int j = 0; j < M; j++) {
                    if (data[i][j] == 1) score++;
                }
                if (max == score) {
                    cnt++;
                } else if (max < score) {
                    max = score;
                    cnt = 1;
                }
            }

            sb.append("#").append(tc).append(" ").append(cnt).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }

}
