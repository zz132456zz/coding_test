// 백준 11852 - 1로 만들기 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_12852 {

    public static class Data {
        int cnt;
        StringBuilder sb;

        public Data(int cnt, StringBuilder sb) {
            this.cnt = cnt;
            this.sb = sb;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Data[] dp = new Data[N + 1];

        dp[1] = new Data(0, new StringBuilder("1"));
        for (int i = 2; i <= N; i++) {
            dp[i] = new Data(Integer.MAX_VALUE, new StringBuilder());
        }

        for (int i = 1; i < N; i++) {
            int i1 = i * 3;
            int i2 = i * 2;
            int i3 = i + 1;
            if (i1 <= N && dp[i].cnt + 1 < dp[i1].cnt) {
                StringBuilder temp = new StringBuilder();
                dp[i1].cnt = dp[i].cnt + 1;
                dp[i1].sb = temp.append(i1).append(" ").append(dp[i].sb);
            }

            if (i2 <= N && dp[i].cnt + 1 < dp[i2].cnt) {
                StringBuilder temp = new StringBuilder();
                dp[i2].cnt = dp[i].cnt + 1;
                dp[i2].sb = temp.append(i2).append(" ").append(dp[i].sb);
            }

            if (dp[i].cnt + 1 < dp[i3].cnt) {
                StringBuilder temp = new StringBuilder();
                dp[i3].cnt = dp[i].cnt + 1;
                dp[i3].sb = temp.append(i3).append(" ").append(dp[i].sb);
            }
        }

        System.out.println(dp[N].cnt);
        System.out.println(dp[N].sb);
    }

}
