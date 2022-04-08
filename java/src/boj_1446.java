// 백준 1446 - 지름길

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_1446 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[] dp = new int[10001];
        for (int i = 0; i <= 10000; i++) {
            dp[i] = i;
        }

        int[][] data = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
            data[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < N; i++) {
            int from = data[i][0];
            int to = data[i][1];
            int distance = data[i][2];

            if (dp[from] + distance < dp[to]) {
                dp[to] = dp[from] + distance;

                for (int j = to; j < 10000; j++) {
                    if (dp[j + 1] > dp[j] + 1) dp[j + 1] = dp[j] + 1;
                }
            }
        }

        System.out.println(dp[D]);
    }

}
