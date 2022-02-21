// 백준 1260 - DFS와 BFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1260 {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        boolean[][] matrix = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            matrix[a][b] = true;
            matrix[b][a] = true;
        }

        dfs(N, matrix, new boolean[N + 1], V);
        sb.append("\n");
        bfs(N, matrix, new boolean[N + 1], V);

        System.out.println(sb.toString());
    }

    public static void bfs(int N, boolean[][] matrix, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current).append(" ");

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && matrix[current][i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void dfs(int N, boolean[][] matrix, boolean[] visited, int current) {
        sb.append(current).append(" ");
        visited[current] = true;

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && matrix[current][i]) {
                dfs(N, matrix, visited, i);
            }
        }
    }

}
