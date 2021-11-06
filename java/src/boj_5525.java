// 백준 5525 - IOIOI

import java.util.Scanner;

public class boj_5525 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        String S = scanner.next();
        int answer = 0;
        int[] dp = new int[M];

        for (int i = 1; i < M - 1; i++) {
            if (S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
                dp[i + 1] = dp[i - 1] + 1;
            }
            if (dp[i + 1] >= N) {
                if (S.charAt(i + 1 - 2 * N) == 'I') {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
