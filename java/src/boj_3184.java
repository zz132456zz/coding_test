// 백준 3184 - 양

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_3184 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        boolean[][] visited = new boolean[R][C];
        int[] answer = new int[2];
        for (int i = 0; i < R; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp[j];
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '#') continue;
                if (visited[i][j]) continue;
                int sheep = 0;
                int wolf = 0;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[] {i, j});
                visited[i][j] = true;

                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();

                    if (map[cur[0]][cur[1]] == 'o') {
                        sheep++;
                    } else if (map[cur[0]][cur[1]] == 'v') {
                        wolf++;
                    }

                    for (int d = 0; d < 4; d++) {
                        int nr = cur[0] + delta[d][0];
                        int nc = cur[1] + delta[d][1];
                        if (0 <= nr && nr < R && 0 <= nc && nc < C && !visited[nr][nc] && map[nr][nc] != '#') {
                            queue.add(new int[] {nr, nc});
                            visited[nr][nc] = true;
                        }
                    }
                }

                if (wolf < sheep) {
                    answer[0] += sheep;
                } else {
                    answer[1] += wolf;
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }

}
