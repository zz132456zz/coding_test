// 백준 2636 - 치즈

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2636 {

    public static int cheese;

    public static void findAir(int R, int C, int[][] map) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[R][C];
        queue.add(new int[] {0, 0});

        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = loc[0] + delta[i][0];
                int nc = loc[1] + delta[i][1];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && !visited[nr][nc] && map[nr][nc] != 1) {
                    map[nr][nc] = -1;
                    visited[nr][nc] = true;
                    queue.add(new int[] {nr, nc});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] data = new int[R][C];
        cheese = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                if (data[i][j] == 1) cheese++;
            }
        }

        int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int lastCheese = 0;
        int time = 0;
        while (cheese > 0) {
            lastCheese = cheese;
            findAir(R, C, data);

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (data[i][j] == 1) {
                        for (int k = 0; k < 4; k++) {
                            int nr = i + delta[k][0];
                            int nc = j + delta[k][1];
                            if (0 <= nr && nr < R && 0 <= nc && nc < C && data[nr][nc] == -1) {
                                data[i][j] = 0;
                                cheese--;
                                break;
                            }
                        }
                    }
                }
            }
            time++;
        }

        System.out.println(time);
        System.out.println(lastCheese);
    }

}
