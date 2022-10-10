// SWEA 1961 - 숫자 배열 회전

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1961 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] data = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#").append(tc).append("\n");

            for (int i = 0; i < N; i++) {
                StringBuilder rotation90 = new StringBuilder();
                StringBuilder rotation180 = new StringBuilder();
                StringBuilder rotation270 = new StringBuilder();

                for (int j = 0; j < N; j++) {
                    rotation90.append(data[N - j - 1][i]);
                }
                for (int j = 0; j < N; j++) {
                    rotation180.append(data[N - i - 1][N - j - 1]);
                }
                for (int j = 0; j < N; j++) {
                    rotation270.append(data[j][N - i - 1]);
                }

                sb.append(rotation90.toString()).append(" ").append(rotation180.toString()).append(" ").append(rotation270.toString()).append("\n");
            }
        }

        System.out.print(sb);
    }

}
