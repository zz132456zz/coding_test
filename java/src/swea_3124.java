// SWEA 3124 - 최소 스패닝 트리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_3124 {

    public static class Edge implements Comparable<Edge> {
        int A;
        int B;
        int C;

        public Edge(int a, int b, int c) {
            super();
            A = a;
            B = b;
            C = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.C - o.C;
        }

        @Override
        public String toString() {
            return "Edge [A=" + A + ", B=" + B + ", C=" + C + "]";
        }

    }

    public static int N;
    public static int[] parents;
    public static Edge[] edgeList;

    public static void makeSet() {
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    public static int findSet(int a) {
        if (parents[a] == a) return a;
        return parents[a] = findSet(parents[a]);
    }

    public static boolean union(int a, int b) {
        int A = findSet(a);
        int B = findSet(b);
        if (A == B) return false;
        parents[A] = B;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            long answer = 0;
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            N = V;
            edgeList = new Edge[E];

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                edgeList[i] = new Edge(A, B, C);
            }

            Arrays.sort(edgeList);

            makeSet();

            int cnt = 0;

            for (int i = 0; i < E; i++) {
                if (union(edgeList[i].A, edgeList[i].B)) {
                    cnt++;
                    answer += edgeList[i].C;
                    if (cnt == N - 1) {
                        break;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
