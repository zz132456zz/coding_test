// 백준 1743 - 음식물 피하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1743 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
        }

        int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) continue;
                int cnt = 1;

                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[] {i, j});
                map[i][j] = 0;

                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int nr = cur[0] + delta[k][0];
                        int nc = cur[1] + delta[k][1];
                        if (0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] == 1) {
                            queue.add(new int[] {nr, nc});
                            map[nr][nc] = 0;
                            cnt++;
                        }
                    }
                }

                if (answer < cnt) answer = cnt;
            }
        }

        System.out.println(answer);
    }

}
