// 백준 11725 - 트리의 부모 찾기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_11725 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(br.readLine());
//        int N = scanner.nextInt();

        int[] parent = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        ArrayList<Integer>[] arr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
//            int x = scanner.nextInt();
//            int y = scanner.nextInt();
            arr[x].add(y);
            arr[y].add(x);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int num : arr[now]) {
                if (!visited[num]) {
                    parent[num] = now;
                    q.add(num);
                    visited[num] = true;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }

    }

}
