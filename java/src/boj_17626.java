// 백준 17626 - Four Squares

import java.util.*;

public class boj_17626 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = 5;
        }

        for (int i = 1; i <= (int)Math.pow(n, 0.5); i++) {
            int temp = (int)Math.pow(i, 2);
            dp[temp] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (int)Math.pow(i, 0.5); j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}
