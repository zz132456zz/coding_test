// 백준 7562 - 나이트의 이동

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7562 {

    static int[][] delta = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int l = Integer.parseInt(br.readLine());
            int[] now = new int[3];
            int[] dest = new int[2];
            st = new StringTokenizer(br.readLine());
            now[0] = Integer.parseInt(st.nextToken());
            now[1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            dest[0] = Integer.parseInt(st.nextToken());
            dest[1] = Integer.parseInt(st.nextToken());

            boolean[][] visited = new boolean[l][l];

            Queue<int[]> queue = new LinkedList<>();
            queue.add(now);
            visited[now[0]][now[1]] = true;

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                if (cur[0] == dest[0] && cur[1] == dest[1]) {
                    answer.append(cur[2]).append("\n");
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int nr = cur[0] + delta[i][0];
                    int nc = cur[1] + delta[i][1];
                    if (0 <= nr && nr < l && 0 <= nc && nc < l && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.add(new int[] {nr, nc, cur[2] + 1});
                    }
                }
            }
        }

        System.out.println(answer);

    }

}
