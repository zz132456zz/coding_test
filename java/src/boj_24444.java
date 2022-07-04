// 백준 24444 - 알고리즘 수업 - 너비 우선 탐색 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_24444 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[] answer = new int[N + 1];

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

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        queue.add(R);
        visited[R] = true;
        int cnt = 1;

        answer[R] = cnt++;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int idx : list.get(cur)) {
                if (!visited[idx]) {
                    visited[idx] = true;
                    queue.add(idx);
                    answer[idx] = cnt++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append("\n");
        }

        System.out.print(sb);
    }

}
