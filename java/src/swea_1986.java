// SWEA 1986 - 지그재그 숫자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int answer = 0;

            for (int i = 1; i <= N; i++) {
                if (i % 2 == 0) {
                    answer -= i;
                } else {
                    answer += i;
                }
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
