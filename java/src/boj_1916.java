// 백준 1916 - 최소비용 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1916 {

    static int N, M;
    static ArrayList<ArrayList<int[]>> graph;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE / 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(to).add(new int[] {from, cost});
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        dijkstra(A);

        System.out.println(dist[B]);
    }

    public static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        pq.add(new int[] {start, 0});
        dist[start] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int d = cur[1];

            if (dist[now] < d) continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = dist[now] + graph.get(now).get(i)[1];
                if (cost < dist[graph.get(now).get(i)[0]]) {
                    dist[graph.get(now).get(i)[0]] = cost;
                    pq.offer(new int[] {graph.get(now).get(i)[0], cost});
                }
            }
        }
    }

}
