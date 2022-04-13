// 백준 9205 - 맥주 마시면서 걸어가기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_9205 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] house = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            ArrayList<int[]> store = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                store.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }
            st = new StringTokenizer(br.readLine());
            int[] festival = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            boolean flag = false;

            // bfs
            Queue<int[]> queue = new LinkedList<>();
            boolean[] visited = new boolean[n];
            queue.add(house);

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                if (isPossible(cur, festival)) {
                    flag = true;
                    break;
                }

                for (int i = 0; i < n; i++) {
                    if (!visited[i] && isPossible(cur, store.get(i))) {
                        queue.add(store.get(i));
                        visited[i] = true;
                    }
                }
            }

            if (flag) {
                sb.append("happy\n");
            } else {
                sb.append("sad\n");
            }
        }

        System.out.print(sb);
    }

    public static boolean isPossible(int[] to, int[] from) {
        if (Math.abs(to[0]- from[0]) + Math.abs(to[1] - from[1]) <= 1000) return true;
        return false;
    }

}
