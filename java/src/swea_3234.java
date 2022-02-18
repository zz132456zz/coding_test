// SWEA 3234 - 준혁이의 양팔저울

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class swea_3234 {

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            Integer[] data = new Integer[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(data, Collections.reverseOrder());  // 역순으로 정렬하면 조금 더 빠르다

            answer = 0;
            boolean[] visited = new boolean[N];
            dfs(0, 0, 0, N, data, visited);

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void dfs(int cnt, int left, int right, int N, Integer[] data, boolean[] visited) {
        if (left < right) return;  // 오른쪽 무게가 더 크면 리턴

        if (cnt == N) {  // 끝까지 다 놓을수 있으면 정답수 추가
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(cnt + 1, left + data[i], right, N, data, visited);  // 왼쪽에 놓는 경우 dfs
            dfs(cnt + 1, left, right + data[i], N, data, visited);  // 오른쪽에 놓는 경우 dfs
            visited[i] = false;
        }
    }

}
