// SWEA 5607 - 조합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5607 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            long answer = nCr(N, R, 1234567891);

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

    static long power(long x, long y, long p)  {
        long res = 1L;
        x = x % p;

        while (y > 0) {
            if (y % 2 == 1) res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }

        return res;
    }

    static long nCr(int n, int r, int p) {
        if (r == 0) return 1L;
        if (r == n) return 1L;

        long[] fac = new long[n + 1];
        fac[0] = 1;
        for (int i = 1 ;i <= n; i++) {
            fac[i] = fac[i - 1] * i % p;
        }

        return (fac[n] * power(fac[r], p - 2, p) % p * power(fac[n - r], p - 2, p) % p) % p;
    }

}
