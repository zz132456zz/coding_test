// SWEA 13218 - 조별과제

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_13218 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            sb.append("#").append(tc).append(" ").append(N / 3).append("\n");
        }

        System.out.print(sb);
    }

}
