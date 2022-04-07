// SWEA 1249 - 보급로

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class swea_1249 {

    static class Node implements Comparable<Node> {
        int r;
        int c;
        int cost;

        public Node(int r, int c, int cost) {
            super();
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }

        @Override
        public String toString() {
            return "Node [r=" + r + ", c=" + c + ", cost=" + cost + "]";
        }

    }

    static final int INF = Integer.MAX_VALUE;
    static int N;
    static int[][] map;
    static int[][] minDistance;
    static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(0, 0, 0));

        out : while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curNode.r + delta[i][0];
                int nc = curNode.c + delta[i][1];
                if (0 <= nr && nr < N && 0 <= nc && nc < N) {
                    if (minDistance[nr][nc] > map[nr][nc] + curNode.cost) {
                        minDistance[nr][nc] = map[nr][nc] + curNode.cost;
                        pq.add(new Node(nr, nc, minDistance[nr][nc]));
                        if (nr == N - 1 && nc == N - 1) break out;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int answer = 0;
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j) - '0';
                }
            }

            minDistance = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(minDistance[i], INF);
            }

            dijkstra();

            answer = minDistance[N - 1][N - 1];

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

}

