// 백준 1010 - 다리 놓기

import java.io.*;
import java.util.StringTokenizer;

public class boj_1010 {

    static double combination(int a, int b) {
        double num1 = 1;
        for (int i = a; i > a - b ; i--) {
            num1 *= i;
        }
        double num2 = 1;
        for (int i = 1; i <= b; i++) {
            num2 *= i;
        }
        return num1 / num2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (M / 2 < N) {
                N = M - N;
            }

            long answer = (long) combination(M, N);

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
    }

}
