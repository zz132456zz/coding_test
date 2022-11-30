// SWEA 14692 - 통나무 자르기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_14692 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            sb.append("#").append(tc).append(" ");

            if (N % 2 == 0) {
                sb.append("Alice");
            } else {
                sb.append("Bob");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }

}
