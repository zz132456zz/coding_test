// 백준 24447 - 알고리즘 수업 - 너비 우선 탐색 4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_24447 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        long[] depth = new long[N + 1];
        long[] order = new long[N + 1];

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(list.get(i));
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int orderCnt = 1;

        queue.add(new int[] {R, 0});
        visited[R] = true;
        Arrays.fill(depth, -1);
        depth[R] = 0;
        order[R] = orderCnt++;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int idx : list.get(cur[0])) {
                if (!visited[idx]) {
                    visited[idx] = true;
                    queue.add(new int[] {idx, cur[1] + 1});
                    depth[idx] = cur[1] + 1;
                    order[idx] = orderCnt++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            answer += depth[i] * order[i];
        }

        System.out.println(answer);
    }

}
