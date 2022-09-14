// SWEA 1974 - 스도쿠 검증

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1974 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int answer = 1;
            int[][] map = new int[9][9];
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            t : for (int i = 0; i < 9; i++) {
                int[] check = new int[10];
                for (int j = 0; j < 9; j++) {
                    if (check[map[i][j]] == 1) {
                        answer = 0;
                        break t;
                    }
                    check[map[i][j]]++;
                }
            }

            t : for (int i = 0; i < 9; i++) {
                int[] check = new int[10];
                for (int j = 0; j < 9; j++) {
                    if (check[map[j][i]] == 1) {
                        answer = 0;
                        break t;
                    }
                    check[map[j][i]]++;
                }
            }

            t : for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int r = i * 3;
                    int c = j * 3;
                    int[] check = new int[10];
                    for (int k = r; k < r + 3; k++) {
                        for (int l = c; l < c + 3; l++) {
                            if (check[map[k][l]] == 1) {
                                answer = 0;
                                break t;
                            }
                            check[map[k][l]]++;
                        }
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
