// SWEA 1940 - 가랏! RC카!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1940 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int answer = 0;
            int v = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                if (cmd == 0) {
                    answer += v;
                } else if (cmd == 1) {
                    v += Integer.parseInt(st.nextToken());
                    answer += v;
                } else if (cmd == 2) {
                    v -= Integer.parseInt(st.nextToken());
                    if (v < 0) v = 0;
                    answer += v;
                }
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
