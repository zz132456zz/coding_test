// 백준 2502 - 떡 먹는 호랑이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2502 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp1 = new int[D + 1];
        int[] dp2 = new int[D + 1];

        dp1[1] = 1;
        dp2[1] = 0;
        dp1[2] = 0;
        dp2[2] = 1;

        for (int i = 3; i <= D; i++) {
            dp1[i] = dp1[i - 1] + dp1[i - 2];
            dp2[i] = dp2[i - 1] + dp2[i - 2];
        }

        int A = 1;
        while (true) {
            int n = K - A * dp1[D];
            if (n % dp2[D] == 0) {
                answer.append(A).append("\n").append(n / dp2[D]);
                break;
            }
            A++;
        }

        System.out.println(answer);
    }

}
