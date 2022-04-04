// SWEA 3307 - 최장 증가 부분 수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_3307 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] data = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }

            int[] lis = new int[N + 1];
            Arrays.fill(lis, 1);

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j < i; j++) {
                    if (data[i] >= data[j]) {
                        lis[i] = Math.max(lis[i], lis[j] + 1);
                    }
                }
            }

            Arrays.sort(lis);

            sb.append("#").append(tc).append(" ").append(lis[N]).append("\n");
        }

        System.out.println(sb);
    }

}
