// SWEA 1970 - 쉬운 거스름돈

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1970 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append("\n");
            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < 8; i++) {
                int temp = N / money[i];
                sb.append(temp).append(" ");
                N -= temp * money[i];
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }

}
