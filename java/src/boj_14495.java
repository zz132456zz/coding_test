// 백준 14495 - 피보나치 비스무리한 수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_14495 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n <= 3) {
            System.out.println(1);
            return;
        }

        long[] data = new long[n + 1];
        data[1] = 1;
        data[2] = 1;
        data[3] = 1;
        for (int i = 4; i <= n; i++) {
            data[i] = data[i - 1] + data[i - 3];
        }

        System.out.println(data[n]);
    }

}