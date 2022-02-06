// SWEA 1954 - 달팽이 숫자

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea_1954 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] data = new int[N][N];

            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};
            int direct = 0;  // 0:right, 1:down, 2:left, 3:up

            int row = 0;
            int column = -1;

            int num = 1;
            while (num <= N * N) {
                int x = row + dx[direct];
                int y = column + dy[direct];

                if (0 <= x && x < N && 0 <= y && y < N && data[x][y] == 0) {
                    data[x][y] = num++;
                    row = x;
                    column = y;
                } else {
                    direct = (direct + 1) % 4;
                }
            }

            bw.write("#" + tc + "\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    bw.write(data[i][j] + " ");
                }
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
