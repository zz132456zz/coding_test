// 백준 13549 - 숨바꼭질 3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_13549 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        boolean[] visited = new boolean [200001];

        queue.add(new int[] {N, 0});
        visited[N] = true;

        int time = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            visited[cur[0]] = true;

            if (cur[0] == K) {
                time = cur[1];
                break;
            }

            int to = cur[0] * 2;
            if (to < 200001 && !visited[to]) {
                queue.add(new int[] {to, cur[1]});
            }

            to = cur[0] + 1;
            if (to < 200001 && !visited[to]) {
                queue.add(new int[] {to, cur[1] + 1});
            }

            to = cur[0] - 1;
            if (to >= 0 && !visited[to]) {
                queue.add(new int[] {to, cur[1] + 1});
            }
        }

        System.out.println(time);
    }

}
