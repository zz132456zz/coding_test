// SWEA 7510 - 상원이의 연속 합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_7510 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int answer = 0;
            int N = Integer.parseInt(br.readLine());

            for (int i = 1; i <= N; i++) {
                int sum = 0;
                for (int j = i; j <= N; j++) {
                    sum += j;
                    if (sum == N) {
                        answer++;
                        break;
                    } else if (sum > N) {
                        break;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
