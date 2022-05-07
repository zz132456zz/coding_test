// 백준 11123 - 양 한마리... 양 두마리...

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_11123 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            char[][] map = new char[H][W];
            for (int i = 0; i < H; i++) {
                map[i] = br.readLine().toCharArray();
            }

            int answer = 0;
            boolean[][] visited = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (visited[i][j] || map[i][j] == '.') continue;
                    answer ++;

                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nr = cur[0] + delta[k][0];
                            int nc = cur[1] + delta[k][1];
                            if (0 <= nr && nr < H && 0 <= nc && nc < W && !visited[nr][nc] && map[nr][nc] == '#') {
                                queue.add(new int[] {nr, nc});
                                visited[nr][nc] = true;
                            }
                        }
                    }
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
