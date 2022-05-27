// 프로그래머스 1844 - 게임 맵 최단거리

import java.util.LinkedList;
import java.util.Queue;

public class programmers_1844 {

    public static int solution(int[][] maps) {
        int answer = -1;
        int R = maps.length;
        int C = maps[0].length;
        int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        queue.add(new int[] {0, 0, 1});
        visited[0][0] = true;

        fin : while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + delta[d][0];
                int nc = cur[1] + delta[d][1];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && maps[nr][nc] == 1 && !visited[nr][nc]) {
                    if (nr == R - 1 && nc == C - 1) {
                        answer = cur[2] + 1;
                        break fin;
                    }
                    queue.add(new int[] {nr, nc, cur[2] + 1});
                    visited[nr][nc] = true;
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int result = solution(maps);

        System.out.println(result);
    }

}
