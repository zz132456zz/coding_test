// 백준 10157 - 자리배정

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        if (C * R < K) {
            System.out.println(0);
            return;
        }

        int[][] map = new int[C][R];
        int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int r = 0;
        int c = 0;
        int d = 0;
        int num = 1;
        while (true) {

            if (0 <= r && r < C && 0 <= c && c < R && map[r][c] == 0) {
                if (num == K) {
                    System.out.println((r + 1) + " " + (c + 1));
                }
                map[r][c] = num++;
                r += delta[d][0];
                c += delta[d][1];
            } else {
                r -= delta[d][0];
                c -= delta[d][1];
                d = (d + 1) % 4;
                r += delta[d][0];
                c += delta[d][1];

                if (0 <= r && r < C && 0 <= c && c < R && map[r][c] == 0) {
                    if (num == K) {
                        System.out.println((r + 1) + " " + (c + 1));
                    }
                    map[r][c] = num++;
                    r += delta[d][0];
                    c += delta[d][1];
                } else {
                    break;
                }
            }
        }

    }

}
