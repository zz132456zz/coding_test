// SWEA 2005 - 파스칼의 삼각형

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2005 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            sb.append("#").append(tc).append("\n");
            int[][] data = new int[N][N];
            data[0][0] = 1;
            for (int i = 0; i < N - 1; i++) {
                for (int j = 0; j <= i; j++) {
                    data[i + 1][j] += data[i][j];
                    data[i + 1][j + 1] += data[i][j];
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    sb.append(data[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }

}
