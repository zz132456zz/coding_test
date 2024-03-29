// 백준 24483 - 알고리즘 수업 - 깊이 우선 탐색 5

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_24483 {

    static int N;
    static int cnt;
    static long[] depth;
    static long[] order;
    static ArrayList<ArrayList<Integer>> data;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        depth = new long[N + 1];
        order = new long[N + 1];
        Arrays.fill(depth, -1);
        data = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            data.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            data.get(u).add(v);
            data.get(v).add(u);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(data.get(i));
        }

        visited = new boolean[N + 1];
        cnt = 1;

        dfs(R, 0);

        long answer = 0;
        for (int i = 1; i <= N; i++) {
            answer += order[i] * depth[i];
        }

        System.out.println(answer);
    }

    public static void dfs(int start, int d) {
        visited[start] = true;
        depth[start] = d;
        order[start] = cnt++;

        for (int idx : data.get(start)) {
            if (!visited[idx]) dfs(idx, d + 1);
        }
    }

}
