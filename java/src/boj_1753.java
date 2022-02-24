// 백준 1753 - 최단경로

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1753 {

    static class Node{
        int vertex,weight;
        Node next;

        public Node(int vertex, int weight, Node next) {
            super();
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }
    }

    static class Vertex implements Comparable<Vertex> {
        int no;
        int totalDistance;

        public Vertex(int no, int totalDistance) {
            super();
            this.no = no;
            this.totalDistance = totalDistance;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.totalDistance - o.totalDistance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        final int INF = Integer.MAX_VALUE;

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        Node[] adjList = new Node[V + 1];
        int[] distance = new int[V + 1];
        boolean[] visited = new boolean[V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList[u] = new Node(v, w, adjList[u]);
        }

        Arrays.fill(distance, INF);

        PriorityQueue<Vertex> pQueue = new PriorityQueue<>();
        distance[K] = 0;
        pQueue.offer(new Vertex(K, distance[K]));

        Vertex current = null;
        while (!pQueue.isEmpty()) {
            current = pQueue.poll();
            if (visited[current.no]) continue;

            visited[current.no] = true;

            for (Node temp = adjList[current.no]; temp != null; temp = temp.next) {
                if (!visited[temp.vertex] && distance[temp.vertex] > distance[current.no] + temp.weight) {
                    distance[temp.vertex] = distance[current.no] + temp.weight;
                    pQueue.offer(new Vertex(temp.vertex, distance[temp.vertex]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (distance[i] == INF) {
                sb.append("INF");
            } else {
                sb.append(distance[i]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

}
