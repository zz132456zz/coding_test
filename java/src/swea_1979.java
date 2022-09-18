// SWEA 1979 - 어디에 단어가 들어갈 수 있을까

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1979 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][N];
            int[] num = new int[N + 1];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                int cnt = 0;
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0) {
                        num[cnt]++;
                        cnt = 0;
                    } else {
                        cnt++;
                    }
                }
                num[cnt]++;
            }

            for (int i = 0; i < N; i++) {
                int cnt = 0;
                for (int j = 0; j < N; j++) {
                    if (map[j][i] == 0) {
                        num[cnt]++;
                        cnt = 0;
                    } else {
                        cnt++;
                    }
                }
                num[cnt]++;
            }

            sb.append("#").append(tc).append(" ").append(num[K]).append("\n");
        }

        System.out.print(sb);
    }

}
