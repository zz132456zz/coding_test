// SWEA 3238 - 이항계수 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_3238 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long R = Long.parseLong(st.nextToken());
            long P = Long.parseLong(st.nextToken());

            long answer = nCr(N, R, P);

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

    static long nCr(long n, long r, long p) {
        long[] fac = new long[(int) p + 1];
        fac[0] = 1;
        for (int i = 1; i <= p; i++) {
            fac[i] = fac[i - 1] * i % p;
        }

        long result = 1;
        int x, y;
        while (n != 0 || r != 0) {
            x = (int) (n % p);
            y = (int) (r % p);

            if (x < y) {
                result = 0;
                break;
            }

            result = result * fac[x] % p;
            for (int i = 0; i < p - 2; i++) {
                result = result * fac[x - y] * fac[y] % p;
            }

            n /= p;
            r /= p;
        }

        return result % p;
    }

}
