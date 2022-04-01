// 백준 4485 - 녹색 옷 입은 애가 젤다지?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_4485 {

    static class Node implements Comparable<Node> {
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, pq에 삽입
        pq.offer(new Node(start, 0));
        d[start] = 0;
        while (!pq.isEmpty()) {  // 큐가 비어있지 않다면
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Node node = pq.poll();
            int dist = node.distance;  // 현재 노드까지의 비용
            int now = node.index;  // 현재 노드
            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (d[now] < dist) continue;
            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).distance;
                // 현재 노드를 거쳐서, 다른 노드를 이동하는 거리가 더 짧은 경우
                if(cost < d[graph.get(now).get(i).index]) {
                    d[graph.get(now).get(i).index] = cost;
                    pq.offer(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }
    }

    public static final int INF = Integer.MAX_VALUE;

    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node>> graph;

    // 최단 거리 담을 배열
    public static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int tc = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            int answer = 0;
            int[][] data = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            graph = new ArrayList<>();

            // 모든 간선 graph에 넣기
            for (int i = 0; i < N * N; i++) {
                graph.add(new ArrayList<>());
            }

            // 각 위치에서 사방으로 갈수있으면 추가
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int from = i * N + j;  // 2차원 배열을 1차원 배열로 바꿔서 생각하기
                    for (int k = 0; k < 4; k++) {
                        int nr = i + delta[k][0];
                        int nc = j + delta[k][1];
                        if (0 <= nr && nr < N && 0 <= nc && nc < N) {
                            int to = nr * N + nc;
                            graph.get(from).add(new Node(to, data[nr][nc]));
                        }
                    }
                }
            }

            // 최단 거리 담을 배열 모두 MAX_VALUE 로 초기화
            d = new int[N * N];
            Arrays.fill(d, INF);

            // 다익스트라 시작
            dijkstra(0);

            // 답은 0에서 끝까지 가는 최단거리에 0번째 칸 값을 더한거
            answer = data[0][0] + d[N * N - 1];

            sb.append("Problem ").append(tc++).append(": ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
