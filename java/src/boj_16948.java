// 백준 16948 - 데스 나이트

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16948 {

    static int N;
    static int r1, c1, r2, c2;
    static int[][] delta = {{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        int answer = bfs();

        System.out.println(answer);
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        queue.add(new int[] {r1, c1, 0});
        visited[r1][c1] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nr = cur[0] + delta[i][0];
                int nc = cur[1] + delta[i][1];
                if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc]) {
                    if (nr == r2 && nc == c2) {
                        return cur[2] + 1;
                    }
                    queue.add(new int[] {nr, nc, cur[2] + 1});
                    visited[nr][nc] = true;
                }
            }

        }

        return -1;
    }

}
