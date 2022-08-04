// 백준 11559 - Puyo Puyo

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_11559 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        char[][] map = new char[12][6];
        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }

        while (true) {
            down(map);
            if (explosion(map)) {
                answer++;
            } else {
                break;
            }
        }

        System.out.println(answer);
    }

    public static void down(char[][] map) {
        for (int c = 0; c < 6; c++) {
            Queue<Character> queue = new LinkedList<>();
            for (int r = 11; r >= 0; r--) {
                if (map[r][c] != '.') {
                    queue.add(map[r][c]);
                }
                map[r][c] = '.';
            }

            int size = queue.size();
            for (int r = 11; r > 11 - size; r--) {
                map[r][c] = queue.poll();
            }
        }
    }

    public static boolean explosion(char[][] map) {
        int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[12][6];
        boolean result = false;

        for (int r = 0; r < 12; r++) {
            for (int c = 0; c < 6; c++) {
                if (visited[r][c]) continue;
                if (map[r][c] == '.') {
                    visited[r][c] = true;
                    continue;
                }

                char now = map[r][c];
                Queue<int[]> bomb = new LinkedList<>();
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[] {r, c});
                bomb.add(new int[] {r, c});
                visited[r][c] = true;

                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    for (int d = 0; d < 4; d++) {
                        int nr = cur[0] + delta[d][0];
                        int nc = cur[1] + delta[d][1];
                        if (0 <= nr && nr < 12 && 0 <= nc && nc < 6 && !visited[nr][nc] && map[nr][nc] == now) {
                            visited[nr][nc] = true;
                            queue.offer(new int[] {nr, nc});
                            bomb.offer(new int[] {nr, nc});
                        }
                    }
                }

                if (bomb.size() >= 4) {
                    result = true;
                    while (!bomb.isEmpty()) {
                        int[] cur = bomb.poll();
                        map[cur[0]][cur[1]] = '.';
                    }
                }
            }
        }

        return result;
    }

}
