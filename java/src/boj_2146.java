// 백준 2146 - 다리 만들기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2146 {

    static int N;
    static int[][] map;
    static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int answer = Integer.MAX_VALUE;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int n = 1;
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    makeIsland(i, j, n, visited);
                    n++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    int len = cntBridgeLength(i, j, map[i][j]);
                    if (answer > len) answer = len;
                }
            }
        }

        System.out.println(answer);
    }

    public static int cntBridgeLength (int i, int j, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        queue.add(new int[] {i, j, 0});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nr = cur[0] + delta[k][0];
                int nc = cur[1] + delta[k][1];
                if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc]) {
                    if (map[nr][nc] == 0) {
                        queue.add(new int[] {nr, nc, cur[2] + 1});
                        visited[nr][nc] = true;
                    } else if (map[nr][nc] != n) {
                        return cur[2];
                    }
                }
            }

        }

        return Integer.MAX_VALUE;
    }

    public static void makeIsland(int i, int j, int n, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        visited[i][j] = true;
        map[i][j] = n;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nr = cur[0] + delta[k][0];
                int nc = cur[1] + delta[k][1];
                if (0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc] && map[nr][nc] == 1) {
                    queue.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                    map[nr][nc] = n;
                }
            }
        }
    }

}
