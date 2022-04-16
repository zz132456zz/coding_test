// 백준 12851 - 숨바꼭질 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_12851 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[200001];

        queue.add(new int[] {N, 0});

        int time = 0;
        int cnt = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            visited[cur[0]] = true;

            if (cnt != 0 && cur[0] == K && cur[1] == time) {
                cnt++;
            }

            if (cnt == 0 && cur[0] == K) {
                time = cur[1];
                cnt++;
            }

            int to = cur[0] - 1;
            if (to >= 0 && !visited[to]) {
                queue.add(new int[] {to, cur[1] + 1});
            }
            to = cur[0] + 1;
            if (to < 200001 && !visited[to]) {
                queue.add(new int[] {to, cur[1] + 1});
            }

            to = cur[0] * 2;
            if (to < 200001 && !visited[to]) {
                queue.add(new int[] {to, cur[1] + 1});
            }
        }

        System.out.println(time);
        System.out.println(cnt);
    }

}
