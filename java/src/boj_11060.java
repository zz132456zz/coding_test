// 백준 11060 - 점프 점프

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_11060 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[] map = new int[N];
        boolean[] visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, map[0], 0});
        visited[0] = true;

        if (N == 1) {
            System.out.println(0);
        } else {
            fin:
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                for (int i = cur[0] + 1; i <= cur[0] + cur[1]; i++) {
                    if (i == N - 1) {
                        System.out.println(cur[2] + 1);
                        flag = false;
                        break fin;
                    }

                    if (!visited[i]) {
                        visited[i] = true;
                        queue.add(new int[]{i, map[i], cur[2] + 1});
                    }
                }
            }

            if (flag) System.out.println("-1");
        }
    }

}
