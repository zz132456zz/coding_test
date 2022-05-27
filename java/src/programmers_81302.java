// 프로그래머스 81302 - 거리두기 확인하기

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class programmers_81302 {

    static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            answer[i] = check(places[i]);
        }

        return answer;
    }

    public static int check(String[] place) {
        char[][] map = new char[5][5];
        for (int i = 0; i < 5; i++) {
            map[i] = place[i].toCharArray();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 'P') {
                    Queue<int[]> queue = new LinkedList<>();
                    boolean[][] visited = new boolean[5][5];
                    queue.add(new int[] {i, j, 0});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();

                        if (cur[2] == 2) continue;

                        for (int d = 0; d < 4; d++) {
                            int nr = cur[0] + delta[d][0];
                            int nc = cur[1] + delta[d][1];
                            if (0 <= nr && nr < 5 && 0 <= nc && nc < 5 && !visited[nr][nc]) {
                                if (map[nr][nc] == 'P') return 0;
                                else if (map[nr][nc] == 'X') continue;
                                queue.add(new int[] {nr, nc, cur[2] + 1});
                                visited[nr][nc] = true;
                            }
                        }
                    }
                }
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] result = solution(places);

        System.out.println(Arrays.toString(result));

    }

}
