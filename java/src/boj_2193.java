// 백준 2193 - 이친수

import java.io.*;

public class boj_2193 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        long[] zero = new long[N + 1];
        long[] one = new long[N + 1];
        zero[1] = 0;
        one[1] = 1;

        for (int i = 2; i <= N; i++) {
            zero[i] = zero[i - 1] + one[i - 1];
            one[i] = zero[i - 1];
        }

        bw.write((zero[N] + one[N]) + "\n");
        bw.flush();
        bw.close();
    }

}
