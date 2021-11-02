// 백준 9561 - 파도반 수열

import java.util.Scanner;

public class boj_9461 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        StringBuilder sb = new StringBuilder();

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        for (int i = 6; i <= 100; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            sb.append(dp[N] + "\n");
        }

        System.out.println(sb);
    }

}
