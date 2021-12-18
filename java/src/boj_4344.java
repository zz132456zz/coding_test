// 백준 4344 - 평균은 넘겠지

import java.io.*;
import java.util.StringTokenizer;

public class boj_4344 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int C = Integer.parseInt(br.readLine());
        for (int c = 0; c < C; c++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] data = new int[N];
            double sum = 0;
            for (int i = 0; i < N; i++) {
                data[i] = Integer.parseInt(st.nextToken());
                sum += data[i];
            }
            double avg = sum / N;

            double up = 0;
            for (int i = 0; i < N; i++) {
                if (data[i] > avg) {
                    up++;
                }
            }

            bw.write(String.format("%.3f", up / N * 100) + "%\n");
        }

        bw.flush();
        bw.close();
    }

}
