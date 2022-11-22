// SWEA 3142 - 영준이와 신비한 뿔의 숲

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_3142 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append("#").append(tc).append(" ");

            for (int i = 0; i <= m; i++) {
                if (i * 2 + m - i == n) {
                    sb.append(m - i).append(" ").append(i).append("\n");
                    break;
                }
            }

        }

        System.out.print(sb);
    }

}
