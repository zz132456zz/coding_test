// SWEA 1976 - 시각 덧셈

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1976 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());

            int h = (m1 + m2) / 60;
            int m = (m1 + m2) % 60;
            h += h1 + h2;
            h %= 12;
            if (h == 0) h = 12;

            sb.append("#").append(tc).append(" ").append(h).append(" ").append(m).append("\n");
        }

        System.out.print(sb);
    }

}
