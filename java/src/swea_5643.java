// SWEA 5643 - 키 순서

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_5643 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            final int INF = 100000;
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            int[][] map = new int[N + 1][N + 1];
            for (int i = 0; i <= N; i++) {
                Arrays.fill(map[i], INF);
            }
            for (int i = 0; i <= N; i++) {
                map[i][i] = 0;
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = 1;
            }

            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }

            int cnt = N;

            for (int n = 1; n <= N; n++) {
                for (int i = 1; i <= N; i++) {
                    if (n == i) continue;
                    if (map[n][i] == INF && map[i][n] == INF) {
                        cnt--;
                        break;
                    }
                }
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j] == INF) {
                        System.out.print("X ");
                    } else {
                        System.out.print(map[i][j] + " ");
                    }
                }
                System.out.println();
            }

            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);
    }

}
