// 백준 11057 - 오르막 수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11057 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N][10];

        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
                dp[i][j] %= 10007;
            }
        }

        for (int i = 0; i < 10; i++) {
            answer += dp[N - 1][i];
        }
        answer %= 10007;

        System.out.println(answer);
    }

}
