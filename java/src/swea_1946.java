// SWEA 1946 - 간단한 압축 풀기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1946 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append("\n");
            int cnt = 0;
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                for (int j = 0; j < num; j++) {
                    sb.append(c);
                    cnt++;
                    if (cnt == 10) {
                        sb.append("\n");
                        cnt = 0;
                    }
                }
            }
            if (cnt != 0) sb.append("\n");
        }

        System.out.print(sb);
    }

}
