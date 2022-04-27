// 백준 2747 - 피보나치 수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2747 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] fibo = new int[46];
        fibo[0] = 0;
        fibo[1] = 1;

        if (n == 1) {
            System.out.println(1);
        } else {
            for (int i = 2; i <= n; i++) {
                fibo[i] = fibo[i - 1] + fibo[i - 2];
            }
            System.out.println(fibo[n]);
        }

    }

}
