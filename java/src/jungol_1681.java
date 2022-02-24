// 정올 1681 - 해밀턴 순환회로

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol_1681 {

    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[][] data = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] visited = new boolean[N];
        min = Integer.MAX_VALUE;
        visited[0] = true;
        dfs(N, 1, 0, 0, data, visited);

        System.out.println(min);
    }

    public static void dfs(int N, int cnt, int current, int sum, int[][] data, boolean[] visited) {
        if (sum >= min) return;

        if (cnt == N) {
            if (data[current][0] == 0) return;
            sum += data[current][0];
            if (min > sum) min = sum;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && data[current][i] != 0) {
                visited[i] = true;
                dfs(N, cnt + 1, i, sum + data[current][i], data, visited);
                visited[i] = false;
            }
        }
    }

}
