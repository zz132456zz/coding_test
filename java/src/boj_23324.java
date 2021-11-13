// 백준 23324 - 어려운 모든 정점 쌍 최단 거리

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class boj_23324 {

    static long bfs(ArrayList<ArrayList<Integer>> graph, int start, boolean[] visited) {
        long num = 1;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        visited[start] = true;
        while (!deque.isEmpty()) {
            int v = deque.pollFirst();
            for (int i : graph.get(v)) {
                if (!visited[i]) {
                    num++;
                    deque.addLast(i);
                    visited[i] = true;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int x = -1;
        int y = -1;

        for (int i = 1; i <= M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (i == K) {
                x = a;
                y = b;
            } else {
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
        }

        boolean[] visited1 = new boolean[N + 1];
        long num1 = bfs(graph, x, visited1);
        boolean[] visited2 = new boolean[N + 1];
        long num2 = bfs(graph, y, visited2);

        if (N == num1) {
            System.out.println(0);
        } else {
            System.out.println(num1 * num2);
        }
    }
}

