// 백준 9084 - 동전

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9084 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] data = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());

            int[][] map = new int[N + 1][M + 1];
            for (int i = 0; i <= N; i++) {
                map[i][0] = 1;
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    map[i][j] += map[i - 1][j];
                    if (j - data[i] >= 0) map[i][j] += map[i][j - data[i]];
                }
            }

            sb.append(map[N][M]).append("\n");
        }

        System.out.print(sb);
    }

}
