// SWEA 1220 - Magnetic

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1220 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] data = new int[N][N];
            int answer = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (data[j][i] == 1) {
                        break;
                    } else if (data[j][i] == 2) {
                        data[j][i] = 0;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = N - 1; j >= 0; j--) {
                    if (data[j][i] == 2) {
                        break;
                    } else if (data[j][i] == 1) {
                        data[j][i] = 0;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                int now = 1;
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    if (data[j][i] != 0 && data[j][i] != now) {
                        sum++;
                        now = data[j][i];
                    }
                }
                answer += (sum + 1) / 2;
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");

        }
        System.out.println(sb.toString());
    }

}

