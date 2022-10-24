// SWEA 10505 - 소득 불균형

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_10505 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] data = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }
            int answer = 0;
            double mean = 0;

            for (int i = 0; i < N; i++) {
                mean += data[i];
            }

            mean /= N;

            for (int i = 0; i < N; i++) {
                if (mean >= data[i]) answer++;
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
