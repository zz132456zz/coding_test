// SWEA 2001 - 파리 퇴치

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class swea_2001 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] data = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = Integer.MIN_VALUE;
            for (int i = 0; i < N - M + 1; i++) {
                for (int j = 0; j < N - M + 1; j++) {
                    int sum = 0;
                    for (int i2 = i; i2 < i + M; i2++) {
                        for (int j2 = j; j2 < j + M; j2++) {
                            sum += data[i2][j2];
                        }
                    }
                    answer = Math.max(answer, sum);
                }
            }

            bw.write("#" + tc + " " + answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
