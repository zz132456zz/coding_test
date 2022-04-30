// 백준 2096 - 내려가기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2096 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] data = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
            data[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] max = new int[N][3];
        int[][] min = new int[N][3];
        max[0][0] = data[0][0];
        max[0][1] = data[0][1];
        max[0][2] = data[0][2];
        min[0][0] = data[0][0];
        min[0][1] = data[0][1];
        min[0][2] = data[0][2];

        for (int i = 1; i < N; i++) {
            max[i][0] = data[i][0] + Math.max(max[i - 1][0], max[i - 1][1]);
            max[i][1] = data[i][1] + Math.max(max[i - 1][0], Math.max(max[i - 1][1], max[i - 1][2]));
            max[i][2] = data[i][2] + Math.max(max[i - 1][1], max[i - 1][2]);
            min[i][0] = data[i][0] + Math.min(min[i - 1][0], min[i - 1][1]);
            min[i][1] = data[i][1] + Math.min(min[i - 1][0], Math.min(min[i - 1][1], min[i - 1][2]));
            min[i][2] = data[i][2] + Math.min(min[i - 1][1], min[i - 1][2]);
        }

        sb.append(Math.max(max[N - 1][0], Math.max(max[N - 1][1], max[N - 1][2]))).append(" ");
        sb.append(Math.min(min[N - 1][0], Math.min(min[N - 1][1], min[N - 1][2])));

        System.out.println(sb);
    }

}
