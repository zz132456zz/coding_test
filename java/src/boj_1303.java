// 백준 1303 - 전쟁 - 전투

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1303 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[M][N];
        for (int i = 0; i < M; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int blue = 0;
        int white = 0;
        boolean[][] visited = new boolean[M][N];
        int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    char now = map[i][j];
                    int cnt = 1;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for (int d = 0; d < 4; d++) {
                            int nr = cur[0] + delta[d][0];
                            int nc = cur[1] + delta[d][1];
                            if (0 <= nr && nr < M && 0 <= nc && nc < N && !visited[nr][nc] && map[nr][nc] == now) {
                                cnt++;
                                visited[nr][nc] = true;
                                queue.add(new int[] {nr, nc});
                            }
                        }
                    }

                    if (now == 'B') {
                        blue += cnt * cnt;
                    } else {
                        white += cnt * cnt;
                    }
                }
            }
        }

        answer.append(white).append(" ").append(blue);

        System.out.println(answer);
    }

}
