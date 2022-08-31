// 백준 11048 - 이동하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11048 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int max = 0;
                if (i - 1 >= 0) max = Math.max(max, map[i- 1][j]);
                if (j - 1 >= 0) max = Math.max(max, map[i][j - 1]);
                if (i - 1 >= 0 && j - 1 >= 0) max = Math.max(max, map[i - 1][j - 1]);
                map[i][j] += max;
            }
        }

        System.out.println(map[N - 1][M - 1]);
    }

}
