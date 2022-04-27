// 백준 10826 - 피보나치 수 4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class boj_10826 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        BigInteger[] fibo = new BigInteger[10001];
        fibo[0] = BigInteger.valueOf(0);
        fibo[1] = BigInteger.valueOf(1);

        if (n == 0) {
            System.out.println(0);
        } else if (n == 1) {
            System.out.println(1);
        } else {
            for (int i = 2; i <= n; i++) {
                fibo[i] = fibo[i - 1].add(fibo[i - 2]);
            }
            System.out.println(fibo[n]);
        }

    }

}
