// 백준 1238 - 파티

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1238 {
    
    static final int INF = (int) 1e9;
    static int N, M, X;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static int[] d = new int[1001];
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            graph.get(from).add(new int[] {to, time});
        }

        int max = 0;

        for (int i = 1; i <= N; i++) {
            int sum = 0;
            Arrays.fill(d, INF);
            dijkstra(i);
            sum += d[X];
            Arrays.fill(d, INF);
            dijkstra(X);
            sum += d[i];
            max = Math.max(max,sum);
        }

        System.out.println(max);
    }

    public static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
        pq.offer(new int[] {start, 0});
        d[start] = 0;
        while(!pq.isEmpty()) { // 큐가 비어있지 않다면
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            int[] node = pq.poll();
            int dist = node[1]; // 현재 노드까지의 비용
            int now = node[0]; // 현재 노드
            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (d[now] < dist) continue;
            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i)[1];
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[graph.get(now).get(i)[0]]) {
                    d[graph.get(now).get(i)[0]] = cost;
                    pq.offer(new int[] {graph.get(now).get(i)[0], cost});
                }
            }
        }
    }

}
