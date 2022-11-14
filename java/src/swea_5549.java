// SWEA 5549 - 홀수일까 짝수일까

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_5549 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String num = br.readLine();
            int last_num = num.charAt(num.length() - 1) - '0';

            sb.append("#").append(tc).append(" ");

            if (last_num % 2 == 0) {
                sb.append("Even");
            } else {
                sb.append("Odd");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }

}
