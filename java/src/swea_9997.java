// SWEA 9997 - 미니멀리즘 시계

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_9997 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int m = N * 2;

            sb.append("#").append(tc).append(" ");
            sb.append(m / 60).append(" ");
            sb.append(m % 60).append("\n");
        }

        System.out.print(sb);
    }

}
