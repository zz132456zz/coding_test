// 백준 14503 - 로봇 청소기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14503 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 0:북 1:동 2:남 3:서

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];  // 0:빈 칸 1:벽 2:청소한 칸
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if (map[r][c] == 0) {
                map[r][c] = 2;
                answer++;
            }

            int i = 0;
            for (i = 1; i <= 4; i++) {
                int nr = r + delta[Math.floorMod(d - i, 4)][0];
                int nc = c + delta[Math.floorMod(d - i, 4)][1];
                if (map[nr][nc] == 0) {
                    d = Math.floorMod(d - i, 4);
                    r = nr;
                    c = nc;
                    break;
                }
            }

            if (i == 5) {
                int nr = r + delta[Math.floorMod(d - 2, 4)][0];
                int nc = c + delta[Math.floorMod(d - 2, 4)][1];
                if (map[nr][nc] == 1) {
                    break;
                } else {
                    r = nr;
                    c = nc;
                }
            }
        }

        System.out.println(answer);
    }

}
