// 백준 2644 - 촌수계산

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2644 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int person1 = Integer.parseInt(st.nextToken());
        int person2 = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 1][n  + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            map[y][x] = 1;
        }

        int answer = -1;
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {person1, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            visited[cur[0]] = true;
            if (cur[0] == person2) {
                answer = cur[1];
                break;
            }

            for (int i = 0; i <= n; i++) {
                if (!visited[i] && map[cur[0]][i] == 1) {
                    queue.add(new int[] {i, cur[1] + 1});
                }
            }
        }

        System.out.println(answer);
    }

}
