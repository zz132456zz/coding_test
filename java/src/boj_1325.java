// 백준 1325 - 효율적인 해킹

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1325 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }

        int max = 0;
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            map.get(B).add(A);
        }

        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            boolean[] visited = new boolean[N + 1];
            visited[i] = true;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (int computer : map.get(cur)) {
                    if (!visited[computer]) {
                        queue.add(computer);
                        visited[computer] = true;
                        cnt++;
                    }
                }
            }

            if (cnt > max) {
                max = cnt;
                answer.clear();
                answer.add(i);
            } else if (cnt == max) {
                answer.add(i);
            }
        }

        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i)).append(" ");
        }

        System.out.println(sb);
    }

}
