// SWEA 2805 - 농작물 수확하기

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea_2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] data = new int[N][N];
            for (int i = 0; i < N; i++) {
                String temp = br.readLine();
                for (int j = 0; j < N; j++) {
                    data[i][j] = temp.charAt(j) - '0';
                }
            }

            int center = N / 2;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (Math.abs(center - i) + Math.abs(center - j) <= center) {
                        sum += data[i][j];
                    }
                }
            }

            bw.write("#" + tc + " " + sum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
