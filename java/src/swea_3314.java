// SWEA 3314 - 보충학습과 평균

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_3314 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int answer = 0;
            int[] data = new int[5];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 5; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }

            int sum = 0;
            for (int i = 0; i < 5; i++) {
                if (data[i] < 40) {
                    data[i] = 40;
                }
                sum += data[i];
            }

            answer = sum / 5;

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
