// 백준 10844 - 쉬운 계단 수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10844 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][10];

        for (int i = 1; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                if (j + 1 < 10) {
                    dp[i][j] += dp[i - 1][j + 1];
                }
                dp[i][j] %= 1000000000;
            }
        }

        for (int i = 0; i < 10; i++) {
            answer += dp[N - 1][i];
            answer %= 1000000000;
        }

        System.out.println(answer);
    }

}
