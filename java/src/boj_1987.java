// 백준 1987 - 알파벳

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1987 {

    static int R, C;
    static char[][] data;
    static int answer;
    static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        data = new char[R][];
        for (int i = 0; i < R; i++) {
            data[i] = br.readLine().toCharArray();
        }

        boolean[] visited = new boolean[26];
        visited[data[0][0] - 'A'] = true;
        dfs(0, 0, visited, 1);

        System.out.println(answer);
    }

    public static void dfs(int r, int c, boolean[] visited, int d) {
        if (answer < d) answer = d;

        for (int i = 0; i < delta.length; i++) {
            int nr = r + delta[i][0];
            int nc = c + delta[i][1];
            if (0 <= nr && nr < R && 0 <= nc && nc < C)  {
                if (!visited[data[nr][nc] - 'A']) {
                    visited[data[nr][nc] - 'A'] = true;
                    dfs(nr, nc, visited, d + 1);
                    visited[data[nr][nc] - 'A'] = false;
                }
            }
        }
    }

}
