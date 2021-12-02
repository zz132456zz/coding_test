// 백준 1904 - 01타일

import java.io.*;

public class boj_1904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] answer = new int[N + 1];
        if (N > 2) {
            answer[1] = 1;
            answer[2] = 2;
            for (int i = 3; i <= N; i++) {
                answer[i] = (answer[i - 1] + answer[i - 2]) % 15746;
            }
            bw.write(answer[N] + "\n");
        } else {
            bw.write(N + "\n");
        }

        bw.flush();
        bw.close();
    }

}
