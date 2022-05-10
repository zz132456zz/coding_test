// 백준 14719 - 빗물

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14719 {

    static int H, W;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        int[] data = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        map = new int[H][W];
        for (int i = 0; i < W; i++) {
            for (int j = H - 1; j > H - data[i] - 1; j--) {
                map[j][i] = 1;
            }
        }

        int answer = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 0) {
                    if (check(i, j)) answer++;
                }
            }
        }

        System.out.println(answer);
    }

    public static boolean check(int r, int c) {
        int cnt = 0;

        for (int i = 0; i < c; i++) {
            if (map[r][i] == 1) {
                cnt++;
                break;
            }
        }

        for (int i = c + 1; i < W; i++) {
            if (map[r][i] == 1) {
                cnt++;
                break;
            }
        }

        if (cnt == 2) {
            return true;
        } else {
            return false;
        }
    }

}
