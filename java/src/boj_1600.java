// 백준 1600 - 말이 되고픈 원숭이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1600 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][] data = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] mvPerson = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] mvHorse = {{-2, -1}, {-2, 1}, {-1, 2}, {-1, -2}, {1, 2}, {1, -2}, {2, 1}, {2, -1}};

        Queue<int[]> queue = new LinkedList<>();
        int[][] remainK = new int[H][W];
        boolean[][] visited = new boolean[H][W];
        queue.add(new int[] {0, 0, 0, K});
        remainK[0][0] = K;
        visited[0][0] = true;
        int answer = -1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == H - 1 && now[1] == W - 1) {
                answer = now[2];
                break;
            }

            for (int i = 0; i < 4; i++) {  // 사람
                int nr = now[0] + mvPerson[i][0];
                int nc = now[1] + mvPerson[i][1];
                if (0 <= nr && nr < H && 0 <= nc && nc < W && data[nr][nc] == 0) {
                    if (visited[nr][nc] && remainK[nr][nc] >= now[3]) continue;

                    remainK[nr][nc] = now[3];
                    visited[nr][nc] = true;
                    queue.add(new int[] {nr, nc, now[2] + 1, now[3]});
                }
            }

            if (now[3] == 0) continue;  // 더이상 남은 K수가 없다.

            for (int i = 0; i < 8; i++) {  // 말
                int nr = now[0] + mvHorse[i][0];
                int nc = now[1] + mvHorse[i][1];
                if (0 <= nr && nr < H && 0 <= nc && nc < W && data[nr][nc] == 0) {
                    if (visited[nr][nc] && remainK[nr][nc] >= now[3] - 1) continue;

                    remainK[nr][nc] = now[3] - 1;
                    visited[nr][nc] = true;
                    queue.add(new int[] {nr, nc, now[2] + 1, now[3] - 1});
                }
            }
        }

        System.out.println(answer);
    }

}
