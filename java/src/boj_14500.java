// 백준 14500 - 테트로미노

import java.util.Scanner;

public class boj_14500 {
    static int N;
    static int M;
    static int[][] data;
    static int answer = 0;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void dfs(int i, int j, int sum, int depth) {
        if (depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int _x = i + dx[k];
            int _y = j + dy[k];
            if (0 <= _x && _x < N && 0 <= _y && _y < M) {
                if(!visited[_x][_y]) {
                    visited[_x][_y] = true;
                    dfs(_x, _y, sum + data[_x][_y], depth + 1);
                    visited[_x][_y] = false;
                }
            }
        }
    }

    static void remain(int i, int j) {
        int num = 0;
        int sum = data[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < 4; k++) {
            int _x = i + dx[k];
            int _y = j + dy[k];
            if (0 <= _x && _x < N && 0 <= _y && _y < M) {
                num++;
                sum += data[_x][_y];
                min = Math.min(min, data[_x][_y]);
            }
        }

        if (num == 3) {
            answer = Math.max(answer, sum);
        } else if (num == 4) {
            answer = Math.max(answer, sum - min);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        data = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                data[i][j] = scanner.nextInt();
            }
        }

        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, data[i][j], 1);
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                remain(i, j);
            }
        }

        System.out.println(answer);
    }
}
