// 백준 1934 - 최소공배수

import java.io.*;
import java.util.StringTokenizer;

public class boj_1934 {

    static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int gcdNum = gcd(Math.max(A, B), Math.min(A, B));

            int lcm = A * B / gcdNum;

            bw.write(lcm + "\n");
        }

        bw.flush();
        bw.close();
    }

}
