// 백준 1926 - 그림

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1926 {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n][m];
        answer = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    bfs(i, j);
                    answer[0]++;
                }
            }
        }

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    public static void bfs(int i, int j) {
        int cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nr = cur[0] + delta[k][0];
                int nc = cur[1] + delta[k][1];
                if (0 <= nr && nr < n && 0 <= nc && nc < m && !visited[nr][nc] && map[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    queue.add(new int[] {nr, nc});
                    cnt++;
                }
            }
        }

        if (answer[1] < cnt) answer[1] = cnt;
    }

}
