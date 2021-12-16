// 백준 23827 - 수열 (Easy)

import java.io.*;
import java.util.StringTokenizer;

public class boj_23827 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] data = new long[N];
        long[] dp = new long[N];
        data[0] = Long.parseLong(st.nextToken());
        dp[0] = data[0];
        for (int i = 1; i < N; i++) {
            data[i] = Long.parseLong(st.nextToken());
            dp[i] = dp[i - 1] + data[i];
        }

        long answer = 0;
        for (int i = 0; i < N - 1; i++) {
            answer = (answer + dp[i] * (data[i + 1])) % 1000000007;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

}
