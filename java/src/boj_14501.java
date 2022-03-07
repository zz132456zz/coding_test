// 백준 14501 - 퇴사

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14501 {

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[][] data = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[N];
        dp(data, visited, 0, 0, N);

        System.out.println(max);
    }

    public static void dp(int[][] data, boolean[] visited, int idx, int sum, int N) {
        if (idx == N) {
            if (sum > max) max = sum;
            return;
        }
        dp(data, visited, idx + 1, sum, N);
        if (data[idx][0] + idx > N) return;
        dp(data, visited, idx + data[idx][0], sum + data[idx][1], N);
    }

}
