// 백준 2573 - 빙산

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2573 {

    static int N;
    static int M;
    static int[][] map;
    static int[][] delta = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int time = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            time++;
            melt();

            int cnt = cntIceberg();

            if (cnt >= 2) {
                System.out.println(time);
                break;
            } else if (cnt == 0) {
                System.out.println(0);
                break;
            }
        }
    }

    public static void melt() {
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    for (int d = 0; d < 4; d++) {
                        int nr = i + delta[d][0];
                        int nc = j + delta[d][1];
                        if (map[nr][nc] == 0 && !visited[nr][nc]) {
                            if (map[i][j] > 0) map[i][j]--;
                            if (map[i][j] == 0) visited[i][j] = true;
                        }
                    }
                }
            }
        }
    }

    public static int cntIceberg() {
        boolean[][] visited = new boolean[N][M];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                    cnt++;

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();

                        for (int d = 0; d < 4; d++) {
                            int nr = cur[0] + delta[d][0];
                            int nc = cur[1] + delta[d][1];
                            if (!visited[nr][nc] && map[nr][nc] != 0) {
                                queue.add(new int[] {nr, nc});
                                visited[nr][nc] = true;
                            }
                        }
                    }
                }
            }
        }

        return cnt;
    }

}
