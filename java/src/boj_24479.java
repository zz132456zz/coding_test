// 백준 24479 - 알고리즘 수업 - 깊이 우선 탐색 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_24479 {

    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> data;
    static int cnt;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

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

        for (int i = 1; i <= N; i++) {
            Collections.sort(data.get(i));
        }

        visited = new boolean[N + 1];
        cnt = 0;
        answer = new int[N + 1];

        dfs(R);

        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int start) {
        cnt++;
        answer[start] = cnt;
        visited[start] = true;

        for (int idx : data.get(start)) {
            if (!visited[idx]) dfs(idx);
        }
    }

}
