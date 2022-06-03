// SWEA 1865 - 동철이의 일 분배

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1865 {

    static int N;
    static double[][] map;
    static double max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new double[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Double.parseDouble(st.nextToken()) / 100;
                }
            }

            max = Double.MIN_VALUE;

            check(0, new boolean[N], 1);

            answer.append("#").append(tc).append(" ").append(String.format("%-6f", max * 100)).append("\n");
        }

        System.out.print(answer);
    }

    public static void check(int depth, boolean[] visited, double mul) {
        if (mul <= max) {
            return;
        }

        if (depth == N) {
            if (max < mul) max = mul;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                check(depth + 1, visited, mul * map[depth][i]);
                visited[i] = false;
            }
        }

    }

}
