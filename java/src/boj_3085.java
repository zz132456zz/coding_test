// 백준 3085 - 사탕 게임

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_3085 {

    static int answer;
    static int N;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] delta = {{0, 1}, {1, 0}};
        answer = 1;
        N = Integer.parseInt(br.readLine());
        map = new char[N][];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int d = 0; d < 2; d++) {
                    int nr = i + delta[d][0];
                    int nc = j + delta[d][1];
                    if (nr < N && nc < N && map[i][j] != map[nr][nc]) {
                        swap(i, j, nr, nc);
                        check();
                        swap(i, j, nr, nc);
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static void swap(int r, int c, int nr, int nc) {
        char temp = map[r][c];
        map[r][c] = map[nr][nc];
        map[nr][nc] = temp;
    }

    public static void check() {
        int max = 1;

        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (map[i][j] == map[i][j + 1]) {
                    cnt++;
                    if (max < cnt) max = cnt;
                } else {
                    cnt = 1;
                }
            }
            cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (map[j][i] == map[j + 1][i]) {
                    cnt++;
                    if (max < cnt) max = cnt;
                } else {
                    cnt = 1;
                }
            }
        }

        if (answer < max) answer = max;
    }

}
