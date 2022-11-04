// SWEA 8658 - Summation

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_8658 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            String[] data = new String[10];
            for (int i = 0; i < 10; i++) {
                data[i] = st.nextToken();
            }

            for (int i = 0; i < 10; i++) {
                int sum = 0;
                for (int j = 0; j < data[i].length(); j++) {
                    sum += data[i].charAt(j) - '0';
                }
                max = Math.max(max, sum);
                min = Math.min(min, sum);
            }

            sb.append("#").append(tc).append(" ").append(max).append(" ").append(min).append("\n");
        }

        System.out.print(sb);
    }

}
