// 백준 14494 - 다이나믹이 뭐에요?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14494 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[][] map = new long[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            map[i][1] = 1;
        }

        for (int i = 1; i <= m; i++) {
            map[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                map[i][j] = map[i - 1][j - 1] + map[i - 1][j] + map[i][j - 1];
                map[i][j] %= 1000000007;
            }
        }

        System.out.println(map[n][m]);
    }

}
