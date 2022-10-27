// SWEA 11688 - Calkin-Wilf tree 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_11688 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String data = br.readLine();
            int a = 1;
            int b = 1;

            for (int i = 0; i < data.length(); i++) {
                if (data.charAt(i) == 'L') {
                    b = a + b;
                } else {
                    a = a + b;
                }
            }

            sb.append("#").append(tc).append(" ").append(a).append(" ").append(b).append("\n");
        }

        System.out.print(sb);
    }

}
