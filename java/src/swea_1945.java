// SWEA 1945 - 간단한 소인수분해

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1945 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] answer = new int[5];

            while (N % 2 == 0) {
                N /= 2;
                answer[0]++;
            }

            while (N % 3 == 0) {
                N /= 3;
                answer[1]++;
            }

            while (N % 5 == 0) {
                N /= 5;
                answer[2]++;
            }

            while (N % 7 == 0) {
                N /= 7;
                answer[3]++;
            }

            while (N % 11 == 0) {
                N /= 11;
                answer[4]++;
            }

            sb.append("#").append(tc);
            for (int i = 0; i < 5; i++) {
                sb.append(" ").append(answer[i]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

}
