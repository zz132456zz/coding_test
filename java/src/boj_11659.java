// 백준 11659 - 구간 합 구하기 4

import java.util.Scanner;

public class boj_11659 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = scanner.nextInt();
        }

        int[] dp = new int[N + 1];
        dp[1] = data[0];
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + data[i - 1];
        }

        for (int m = 0; m < M; m++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            System.out.println(dp[j] - dp[i - 1]);
        }
    }
}
