// SWEA 1209 - Sum

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1209 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < 10; t++) {
            int tc = Integer.parseInt(br.readLine());
            int[][] map = new int[100][100];
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = 0;
            int sum = 0;

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    sum += map[i][j];
                }
                if (answer < sum) answer = sum;
                sum = 0;
                for (int j = 0; j < 100; j++) {
                    sum += map[j][i];
                }
                if(answer < sum) answer = sum;
                sum = 0;
            }

            for (int i = 0; i < 100; i++) {
                sum += map[i][i];
            }
            if (answer < sum) answer = sum;
            sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += map[i][99 - i];
            }
            if (answer < sum) answer = sum;

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
