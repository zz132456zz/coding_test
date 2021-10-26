// 백준 1012 - 유기농 배추

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1012 {

    static class coordinate {
        int x;
        int y;

        public coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int answer = 0;
            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};
            boolean[][] data = new boolean[M][N];

            for (int k = 0; k < K; k++) {
                int X = scanner.nextInt();
                int Y = scanner.nextInt();
                data[X][Y] = true;
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (data[i][j]) {
                        answer++;
                        Queue<coordinate> q = new LinkedList<>();
                        q.add(new coordinate(i, j));
                        data[i][j] = false;

                        while (!q.isEmpty()) {
                            coordinate now = q.poll();
                            for (int d = 0; d < 4; d++) {
                                int _x = now.x + dx[d];
                                int _y = now.y + dy[d];
                                if (0 <= _x && _x < M && 0 <= _y && _y < N) {
                                    if (data[_x][_y]) {
                                        q.add(new coordinate(_x, _y));
                                        data[_x][_y] = false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
