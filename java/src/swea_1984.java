// SWEA 1984 - 중간 평균값 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1984 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int[] data = new int[10];
            for (int i = 0; i < 10; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(data);

            double sum = 0;
            for (int i = 1; i < 9; i++) {
                sum += data[i];
            }
            int min = (int) Math.round(sum / 8);

            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }

        System.out.print(sb);
    }

}
