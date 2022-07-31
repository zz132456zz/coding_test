import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class programmers_test_2_3 {

    public static final int INF = (int) 1e9;
    public static int n;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int[] d;

    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }

        d = new int[n + 1];

        Arrays.fill(d, INF);
        dijkstra(destination);

        for (int i = 0; i < sources.length; i++) {
            if (d[sources[i]] == INF) answer[i] = -1;
            else answer[i] = d[sources[i]];
        }

//        for (int i = 0; i < sources.length; i++) {
//            Arrays.fill(d, INF);
//            dijkstra(sources[i]);
//
//            if (d[destination] == INF) answer[i] = -1;
//            else answer[i] = d[destination];
//        }

        return answer;
    }

    public static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        pq.offer(new int[] {0, start});
        d[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int dist = cur[0];
            int now = cur[1];
            if (d[now] < dist) continue;
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + 1;
                if (cost < d[graph.get(now).get(i)]) {
                    d[graph.get(now).get(i)] = cost;
                    pq.offer(new int[] {cost, graph.get(now).get(i)});
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] roads = {{1, 2}, {2, 3}};
        int[] sources = {2, 3};
        int destination = 1;
        int[] result = solution(n, roads, sources, destination);

        System.out.println(Arrays.toString(result));
    }

}
