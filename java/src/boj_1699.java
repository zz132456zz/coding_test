// 백준 1699 - 제곱수의 합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1699 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dp[i] = i;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }

        System.out.println(dp[N]);
    }

}
