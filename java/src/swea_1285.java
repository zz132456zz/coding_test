// SWEA 1285 - 아름이의 돌 던지기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1285 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] loc = new int[100001];
            int[] data = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                loc[Math.abs(data[i])]++;
            }

            for (int i = 0; i <= 100000; i++) {
                if (loc[i] != 0) {
                    sb.append("#").append(tc).append(" ").append(i).append(" ").append(loc[i]).append("\n");
                    break;
                }
            }
        }

        System.out.print(sb);
    }

}
