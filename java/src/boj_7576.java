// 백준 7576 - 토마토

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7576 {

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] data = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;

        bfs(N, M, data);

        flag : for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (data[i][j] == 0) {
                    answer = -1;
                    break flag;
                }
            }
        }

        System.out.println(answer);
    }

    public static void bfs(int N, int M, int[][] data) {
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> nextQueue = new LinkedList<>();

        int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (data[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = current[0] + delta[i][0];
                int y = current[1] + delta[i][1];
                if (0 <= x && x < N && 0 <= y && y < M) {
                    if (data[x][y] == 0) {
                        data[x][y] = 1;
                        nextQueue.offer(new int[] {x, y});
                    }
                }
            }

            if (queue.isEmpty()) {
                if (nextQueue.isEmpty()) return;

                answer++;
                queue.addAll(nextQueue);
                nextQueue.clear();
            }
        }
    }

}
