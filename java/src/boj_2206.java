// 백준 2206 - 벽 부수고 이동하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2206 {

    static int N, M;
    static int[][] map;
    static int answer;
    static int[][] visited;
    static int[][] delta = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], -1);
        }

        if (N == 1 && M == 1) {
            answer = 1;
        } else {
            answer = -1;
        }

        bfs();

        System.out.println(answer);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 1, 1});
        visited[0][0] = 1;

        // visited -1 : 방문안함, 0 : 방문했는데 벽부순상태로 1 : 방문했는데 벽안부순상태로

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + delta[i][0];
                int nc = cur[1] + delta[i][1];
                if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                    if (visited[nr][nc] < cur[2]) {
                        if (map[nr][nc] == 0) {
                            if (nr == N - 1 && nc == M - 1) {
                                answer = cur[3] + 1;
                                return;
                            }
                            queue.add(new int[] {nr, nc, cur[2], cur[3] + 1});
                            visited[nr][nc] = cur[2];
                        } else {
                            if (cur[2] == 1) {
                                if (nr == N - 1 && nc == M - 1) {
                                    answer = cur[3] + 1;
                                    return;
                                }
                                queue.add(new int[] {nr, nc, cur[2] - 1, cur[3] + 1});
                                visited[nr][nc] = cur[2] - 1;
                            }
                        }
                    }

                }
            }
        }
    }

}
