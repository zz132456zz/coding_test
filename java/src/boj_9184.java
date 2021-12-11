// 백준 9184 - 신나는 함수 실행

import java.io.*;
import java.util.StringTokenizer;

public class boj_9184 {

    static int[][][] dp = new int[21][21][21];

    static boolean isRange(int a, int b, int c) {
        if (a < 0 || b < 0 || c < 0 || a > 20 || b > 20 || c > 20) {
            return false;
        } else {
            return true;
        }
    }

    public static int w(int a, int b, int c) {
        if (isRange(a, b, c) && dp[a][b][c] != 0) {
            return dp[a][b][c];
        }
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }
        if (a < b && b < c) {
            dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            return w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }
        dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        return w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            int answer = w(a, b, c);

            bw.write("w(" + a + ", " + b + ", " + c + ") = " + answer + "\n");
        }

        bw.flush();
        bw.close();
    }

}
