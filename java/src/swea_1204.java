// SWEA 1204 - 최빈수 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1204 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            int[] data = new int[101];
            int answer = 0;
            int cnt = 0;

            for (int i = 0; i < 1000; i++) {
                int score = Integer.parseInt(st.nextToken());
                data[score]++;
            }

            for (int i = 0; i <= 100; i++) {
                if (data[i] >= cnt) {
                    cnt = data[i];
                    answer = i;
                }
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
