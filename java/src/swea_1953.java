// SWEA 1953 - 탈주범 검거

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1953 {

    static int N, M, R, C, L;
    static int[][] map;
    static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};  // 상, 하, 좌, 우
    static int[][] tunnel = {{}, {0, 1, 2, 3}, {0, 1}, {2, 3}, {0, 3}, {1, 3}, {1, 2}, {0, 2}};
    static int[] fit = {1, 0, 3, 2};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            answer = 1;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            BFS();

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

    public static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        queue.add(new int[] {R, C, 1});
        visited[R][C] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int depth = cur[2];
            int type = map[r][c];

            for (int d : tunnel[type]) {  // d - 0:상 1:하 2:좌 3:우
                int nr = r + delta[d][0];
                int nc = c + delta[d][1];
                boolean flag = false;
                if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc]) {
                    int nType = map[nr][nc];
                    for (int nd : tunnel[nType]) {
                        if (fit[d] == nd) flag = true;
                    }
                    if (flag && depth < L) {
                        visited[nr][nc] = true;
                        queue.add(new int[] {nr, nc, depth + 1});
                        answer++;
                    }
                }
            }
        }
    }
}
