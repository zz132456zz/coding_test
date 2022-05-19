// 소프티어 627 - [21년 재직자 대회 예선] 이미지 프로세싱

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class softeer_627 {

    static int H, W;
    static int[][] map;
    static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int Q = Integer.parseInt(br.readLine());
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            bfs(i - 1, j - 1, c);
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                answer.append(map[i][j]).append(" ");
            }
            answer.append("\n");
        }

        System.out.print(answer);
    }

    public static void bfs(int i, int j, int c) {
        int curColor = map[i][j];

        boolean[][] visited = new boolean[H][W];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        visited[i][j] = true;
        map[i][j] = c;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + delta[d][0];
                int nc = cur[1] + delta[d][1];
                if (0 <= nr && nr < H && 0 <= nc && nc < W && !visited[nr][nc] && map[nr][nc] == curColor) {
                    queue.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                    map[nr][nc] = c;
                }
            }
        }
    }

}
