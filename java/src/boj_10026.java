// 백준 10026 - 적록색약

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_10026 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] data = new char[N][N];
        for (int i = 0; i < N; i++) {
            data[i] = br.readLine().toCharArray();
        }

        boolean[][] visited = new boolean[N][N];
        int answer1 = bfs(data, visited);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (data[i][j] == 'R') data[i][j] = 'G';
            }
        }
        visited = new boolean[N][N];
        int answer2 = bfs(data, visited);

        System.out.println(answer1 + " " + answer2);
    }

    public static int bfs(char[][] data, boolean[][] visited) {
        int N = data.length;
        int cnt = 0;
        int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    cnt++;
                    char now = data[i][j];
                    Queue<int[]> queue = new LinkedList<>();

                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int x = current[0] + delta[k][0];
                            int y = current[1] + delta[k][1];
                            if (0 <= x && x < N && 0 <= y && y < N && !visited[x][y] && data[x][y] == now) {
                                queue.offer(new int[] {x, y});
                                visited[x][y] = true;
                            }
                        }
                    }
                }
            }
        }

        return cnt;
    }

}
