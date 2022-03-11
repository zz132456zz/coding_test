// 백준 1914 - 하노이 탑

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class boj_1914 {

    static int cnt;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        cnt = 0;

        int N = Integer.parseInt(br.readLine());

        if (N <= 20) {
            hanoi(N, 1, 2, 3);
            System.out.println(cnt);
            System.out.print(sb.toString());
        } else {
            BigInteger[] dp = new BigInteger[N + 1];
            dp[1] = BigInteger.valueOf(1);

            for (int i = 2; i <= N; i++) {
                dp[i] = dp[i - 1].add(dp[i - 1]).add(BigInteger.valueOf(1));
            }

            System.out.println(dp[N]);
        }
    }

    public static void hanoi(int N, int from, int mid, int to) {
        if (N == 1) {
            cnt++;
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        hanoi(N - 1, from, to, mid);
        hanoi(1, from, mid, to);
        hanoi(N - 1, mid, from, to);
    }

}
