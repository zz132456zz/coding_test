// 백준 1149 - RGB거리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[][] data = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 2; i <= N; i++) {
            data[i][0] += Math.min(data[i - 1][1], data[i - 1][2]);
            data[i][1] += Math.min(data[i - 1][0], data[i - 1][2]);
            data[i][2] += Math.min(data[i - 1][0], data[i - 1][1]);
        }

        System.out.println(Math.min(data[N][0], Math.min(data[N][1], data[N][2])));
    }

}
