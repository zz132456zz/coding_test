// 백준 9625 - BABBA

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9625 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        int A = 1;
        int B = 0;

        for (int i = 0; i < K; i++) {
            int a = A;
            int b = B;
            A = b;
            B = a + b;
        }

        System.out.println(A + " " + B);
    }


}
