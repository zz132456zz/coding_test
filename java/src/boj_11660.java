// 백준 11660 - 구간 합 구하기 5

import java.io.*;
import java.util.StringTokenizer;

public class boj_11660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] data = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 2; j <= N; j++) {
                data[i][j] = data[i][j] + data[i][j - 1];
            }
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                data[i][j] = data[i][j] + data[i-1][j];
            }
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int answer = data[x2][y2] - data[x1 - 1][y2] - data[x2][y1 - 1] + data[x1 - 1][y1 - 1];

            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }
}
