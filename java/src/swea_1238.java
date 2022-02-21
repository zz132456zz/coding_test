// SWEA 1238 - Contact

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1238 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            boolean[][] matrix = new boolean[101][101];
            st = new StringTokenizer(br.readLine());
            for (int i = 0, size = len / 2; i < size; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                matrix[a][b] = true;
            }

            sb.append("#").append(tc).append(" ").append(bfs(matrix, start)).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int bfs(boolean[][] matrix, int start) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> tempQueue = new LinkedList<>();

        int answer = start;
        int max = 0;

        boolean[] visited = new boolean[101];

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (max < current) max = current;

            for (int i = 1; i <= 100; i++) {
                if (!visited[i] && matrix[current][i]) {
                    visited[i] = true;
                    tempQueue.add(i);
                }
            }

            if (queue.isEmpty()) {
                queue.addAll(tempQueue);
                tempQueue.clear();
                answer = max;
                max = 0;
            }
        }

        return answer;
    }

}
