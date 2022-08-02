// 백준 1504 - 특정한 최단 경로

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1504 {

    static final int INF = (int) 1e7;
    static ArrayList<ArrayList<int[]>> map = new ArrayList<>();
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }
        distance = new int[N + 1];

        int E = Integer.parseInt(st.nextToken());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map.get(a).add(new int[] {b, c});
            map.get(b).add(new int[] {a, c});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int sum = 0;

        Arrays.fill(distance, INF);
        dijkstra(1, v1);
        sum += distance[v1];

        Arrays.fill(distance, INF);
        dijkstra(v1, v2);
        sum += distance[v2];

        Arrays.fill(distance, INF);
        dijkstra(v2, N);
        sum += distance[N];

        answer = sum;

        sum = 0;

        Arrays.fill(distance, INF);
        dijkstra(1, v2);
        sum += distance[v2];

        Arrays.fill(distance, INF);
        dijkstra(v2, v1);
        sum += distance[v1];

        Arrays.fill(distance, INF);
        dijkstra(v1, N);
        sum += distance[N];

        answer = Math.min(sum, answer);

        if (answer >= INF) answer = -1;

        System.out.println(answer);
    }

    public static void dijkstra(int start, int desti) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        pq.offer(new int[] {start, 0});
        distance[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int dist = cur[1];

            ArrayList<int[]> temp = map.get(now);
            for (int i = 0; i < temp.size(); i++) {
                int cost = distance[now] + temp.get(i)[1];
                if (cost < distance[temp.get(i)[0]]) {
                    distance[temp.get(i)[0]] = cost;
                    pq.offer(new int[] {temp.get(i)[0], cost});
                }
            }
        }

    }

}
