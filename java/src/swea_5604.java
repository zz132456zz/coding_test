// SWEA 5604 - 구간 합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5604 {

    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            answer = 0;

            long mul = 1;

            while (A <= B) {
                while (A % 10 != 0 && A <= B) {
                    cal(A, mul);
                    A++;
                }

                if (A > B) break;
                if (A == 0 && B == 0) break;

                while (B % 10 != 9 && A <= B) {
                    cal(B, mul);
                    B--;
                }

                A /= 10;
                B /= 10;

                long temp = (B - A + 1) * mul;
                for (int i = 0; i < 10; i++) {
                    answer += temp * i;
                }

                mul *= 10;
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

    public static void cal(long n, long m) {
        while (n > 0) {
            answer += (n % 10) * m;
            n /= 10;
        }
    }

}
