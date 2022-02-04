// 백준 2615 - 오목

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2615 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        final int SIZE = 19;

        // 우하, 우, 우상, 하 4방향 체크
        int[][][] deltas = {{{0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {-1, -1}},
                {{0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {0, -1}},
                {{0, 0}, {-1, 1}, {-2, 2}, {-3, 3}, {-4, 4}, {-5, 5}, {1, -1}},
                {{0, 0}, {1, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 0}, {-1, 0}}};

        int[][] data = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        flag : for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int now = data[i][j];
                if (now != 0) {
                    for (int k = 0; k < deltas.length; k++) {
                        int cnt = 0;
                        for (int m = 0; m < 5; m++) {
                            int x = i + deltas[k][m][0];
                            int y = j + deltas[k][m][1];
                            if (0 <= x && x < SIZE && 0 <= y && y < SIZE && data[x][y] == now) {
                                cnt++;
                            }
                        }
                        if (cnt == 5) {  // 6목 체크
                            for (int m = 5; m < 7; m++) {
                                int x = i + deltas[k][m][0];
                                int y = j + deltas[k][m][1];
                                if (0 <= x && x < SIZE && 0 <= y && y < SIZE && data[x][y] == now) {
                                    cnt = 0;
                                }
                            }
                        }
                        if (cnt == 5) {  // 진짜 5목이면 break
                            answer = now;
                            System.out.println(now);
                            System.out.println((i + 1) + " " + (j + 1));
                            break flag;
                        }
                    }
                }
            }
        }

        if (answer == 0) {
            System.out.println(answer);
        }

        br.close();
    }

}
