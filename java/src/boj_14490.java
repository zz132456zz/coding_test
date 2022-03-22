// 백준 14490 - 백대열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14490 {

    public static int gcd(int a, int b) {
        while (a != 0) {
            int r = b % a;
            b = a;
            a = r;
        }
        return b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int gcdNum;
        if (A < B) {
            gcdNum = gcd(A, B);
        } else {
            gcdNum = gcd(B, A);
        }

        sb.append(A / gcdNum).append(":").append(B / gcdNum);

        System.out.println(sb);
    }

}
