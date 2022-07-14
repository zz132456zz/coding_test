// 백준 24482 - 알고리즘 수업 - 깊이 우선 탐색 4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_24482 {

    static int N;
    static int[] answer;
    static ArrayList<ArrayList<Integer>> data;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        answer = new int[N + 1];
        Arrays.fill(answer, -1);
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
            Collections.sort(data.get(i), Collections.reverseOrder());
        }

        visited = new boolean[N + 1];

        dfs(R, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append("\n");
        }

        System.out.print(sb);
    }

    public static void dfs(int start, int depth) {
        visited[start] = true;
        answer[start] = depth;

        for (int idx : data.get(start)) {
            if (!visited[idx]) dfs(idx, depth + 1);
        }
    }

}
