// 백준 2589 - 보물섬

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2589 {

    static int R;
    static int C;
    static char[][] map;
    static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'L') {
                    int result = bfs(i, j);
                    if (result > max) max = result;
                }
            }
        }

        System.out.println(max);
    }

    public static int bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        queue.add(new int[] {i, j, 0});
        visited[i][j] = true;
        int cnt = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nr = cur[0] + delta[k][0];
                int nc = cur[1] + delta[k][1];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && !visited[nr][nc] && map[nr][nc] == 'L') {
                    queue.add(new int[] {nr, nc, cur[2] + 1});
                    cnt = cur[2] + 1;
                    visited[nr][nc] = true;
                }
            }
        }

        return cnt;
    }

}
