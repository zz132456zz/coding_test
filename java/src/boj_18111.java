// 백준 18111 - 마인크래프트

import java.io.*;
import java.util.StringTokenizer;

public class boj_18111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] data = new int[N][M];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (max < num) {
                    max = num;
                }
                if (min > num) {
                    min = num;
                }

                data[i][j] = num;
            }
        }

        int time = Integer.MAX_VALUE;
        int height = 0;
        for (int h = min; h <= max; h++) {
            int temp_time = 0;
            int block_plus = 0;
            int block_minus = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (data[i][j] < h) {
                        int temp = h - data[i][j];
                        block_plus += temp;
                        temp_time += temp;
                    } else if (data[i][j] > h) {
                        int temp = data[i][j] - h;
                        block_minus += temp;
                        temp_time += temp * 2;
                    }
                }
            }

            if (B + block_minus < block_plus) { // 인벤토리 체크해서 가능한지
                continue;
            }

            if (time >= temp_time) { // 시간 체크해서 가장 작은거거
                time = temp_time;
                height = h;
            }
        }

        bw.write(time + " ");
        bw.write(height + "\n");
        bw.flush();
        bw.close();
    }

}
