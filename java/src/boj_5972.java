// 백준 5972 - 택배 배송

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_5972 {

    public static class Node implements Comparable<Node> {
        int idx;
        int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        public int getIdx() {
            return idx;
        }

        public int getDist() {
            return dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }

        int[] d = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            d[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        d[1] = 0;
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.getIdx();
            int dist = cur.getDist();

            if (d[now] < dist) continue;
            for (int i = 0; i < list.get(now).size(); i++) {
                int cost = d[now] + list.get(now).get(i).getDist();
                if (cost < d[list.get(now).get(i).getIdx()]) {
                    d[list.get(now).get(i).getIdx()] = cost;
                    pq.offer(new Node(list.get(now).get(i).getIdx(), cost));
                }
            }
        }

        System.out.println(d[N]);
    }

}
