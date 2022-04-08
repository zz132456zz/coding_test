// 백준 17135 - 캐슬 디펜스

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_17135 {

    static int N, M, D;
    static int[][] map;
    static int[] archer;
    static int[][] delta = {{0, -1}, {-1, 0}, {0, 1}};
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        archer = new int[3];  // 궁수 위치는 (N, archer[0]), (N, archer[1]), (N, archer[2])
        max = Integer.MIN_VALUE;

        combination(0, 0);

        System.out.println(max);
    }

    public static void combination(int start, int depth) {
        if (depth == 3) {
            play();
            return;
        }

        for (int i = start; i < M; i++) {
            archer[depth] = i;
            combination(i + 1, depth + 1);
        }
    }

    public static void play() {
        int[][] temp = deepCopy(map);

        int removeCnt = 0;

        for (int i = 0; i < N; i++) {
            ArrayList<int[]> enemyList = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                int[] result = shoot(N, archer[j], temp);
                if (result[0] != -1) enemyList.add(result);
            }

            for (int[] e : enemyList) {
                temp[e[0]][e[1]] = 0;
                removeCnt++;
            }

            move(temp);
        }

        if (max < removeCnt) max = removeCnt;
    }

    public static int[] shoot(int r, int c, int[][] m) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new int[] {r, c, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 3; i++) {
                int nr = cur[0] + delta[i][0];
                int nc = cur[1] + delta[i][1];
                if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc] && cur[2] < D) {
                    if (m[nr][nc] > 0) {
                        if (m[nr][nc] == 1) {
                            m[nr][nc] = 2;
                            return new int[] {nr, nc};
                        }
                        return new int[] {-1, -1};
                    }
                    queue.add(new int[] {nr, nc, cur[2] + 1});
                    visited[nr][nc] = true;
                }
            }
        }

        return new int[] {-1, -1};
    }

    public static void move(int[][] m) {
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < M; j++) {
                m[i][j] = m[i - 1][j];
            }
        }
        for (int j = 0; j < M; j++) {
            m[0][j] = 0;
        }
    }

    public static int[][] deepCopy(int[][] m) {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = m[i][j];
            }
        }
        return temp;
    }

}
