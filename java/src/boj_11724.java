// 백준 11724 - 연결 요소의 개수

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_11724 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        boolean[] visited = new boolean[N + 1];
        int answer = 0;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int n = 0; n <= N; n++) {
            graph.add(new ArrayList<>());
        }

        for (int m = 0; m < M; m++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]){
                answer++;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i] = true;

                while (!q.isEmpty()) {
                    int now = q.poll();
                    for (int j : graph.get(now)) {
                        if (!visited[j]) {
                            q.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
