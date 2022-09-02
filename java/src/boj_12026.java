// 백준 12026 - BOJ 거리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_12026 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;

        for (int i = 0; i < N - 1; i++) {
            char cur = str.charAt(i);
            char next;

            if (cur == 'B') next = 'O';
            else if (cur == 'O') next = 'J';
            else next = 'B';

            for (int j = i + 1; j < N; j++) {
                if (str.charAt(j) == next) {
                    dp[j] = Math.min(dp[j], dp[i] + (j - i) * (j - i));
                }
            }
        }

        if (dp[N - 1] == Integer.MAX_VALUE / 2) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N - 1]);
        }
    }

}
