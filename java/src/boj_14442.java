// 백준 14442 - 벽 부수고 이동하기 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14442 {

    static int N, M, K;
    static int[][] map;
    static int[][] visited;
    static int[][] delta = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], -1);
        }

        bfs();

        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, K, 1});
        visited[0][0] = K;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == N - 1 && cur[1] == M - 1) {
                min = cur[3];
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + delta[d][0];
                int nc = cur[1] + delta[d][1];
                if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                    if (map[nr][nc] == 1 && visited[nr][nc] < cur[2] && cur[2] != 0) {
                        visited[nr][nc] = cur[2];
                        queue.offer(new int[] {nr, nc, cur[2] - 1, cur[3] + 1});
                    } else if (map[nr][nc] == 0 && visited[nr][nc] < cur[2]) {
                        visited[nr][nc] = cur[2];
                        queue.offer(new int[] {nr, nc, cur[2], cur[3] + 1});
                    }
                }
            }
        }
    }

}
