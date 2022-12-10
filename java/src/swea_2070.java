// SWEA 2070 - 큰 놈, 작은 놈, 같은 놈

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2070 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append("#").append(tc).append(" ");
            if (A < B) {
                sb.append("<");
            } else if (A > B) {
                sb.append(">");
            } else {
                sb.append("=");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }


}
