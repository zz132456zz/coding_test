// 백준 2210 - 숫자판 점프

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_2210 {

    public static Set<String> set;

    public static void dfs(int[][] data, int depth, int r, int c, StringBuilder sb) {
        if (depth == 6) {
            set.add(sb.toString());
            return;
        }

        int[][] delta = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int i = 0; i < 4; i++) {
            int nr = r + delta[i][0];
            int nc = c + delta[i][1];
            if (0 <= nr && nr < 5 && 0 <= nc && nc < 5) {
                dfs(data, depth + 1, nr, nc, sb.append(data[nr][nc]));
                sb.setLength(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int[][] data = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        set = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                StringBuilder sb = new StringBuilder();
                dfs(data, 1, i, j, sb.append(data[i][j]));
            }
        }

        System.out.println(set.size());
    }

}
