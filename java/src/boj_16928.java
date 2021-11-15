// 백준 16928 - 뱀과 사다리 게임

import java.util.*;

public class boj_16928 {
    static Map<Integer, Integer> ladder_snake;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        ladder_snake = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            ladder_snake.put(x, y);
        }
        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            ladder_snake.put(u, v);
        }

        boolean[] visited = new boolean[101];
        Queue<Integer> q = new LinkedList<>();
        int depth = 0;

        visited[1] = true;
        q.offer(1);

        while(!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int now = q.poll();
                if (now == 100) {
                    System.out.println(depth);
                    return;
                }

                for (int j = 1; j <= 6; j++) {
                    int next = now + j;
                    if (next > 100) {
                        break;
                    }
                    if (visited[next]) {
                        continue;
                    }
                    if (ladder_snake.containsKey(next)) {
                        next = ladder_snake.get(next);
                        if (visited[next]) {
                            continue;
                        }
                    }
                    q.offer(next);
                    visited[next] = true;
                }
            }
            depth++;
        }
    }
}
