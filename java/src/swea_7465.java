// SWEA 7465 - 창용 마을 무리의 개수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_7465 {

    static int N;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            makeSet();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            int[] sum = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                findParent(i);
                sum[parents[i]] = 1;
            }

            int answer = 0;
            for (int i = 1; i <= N; i++) {
                answer += sum[i];
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void makeSet() {
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    public static int findParent(int a) {
        if (parents[a] == a) return a;
        return parents[a] = findParent(parents[a]);
    }

    public static void union(int a, int b) {
        if (findParent(a) == findParent(b)) return;
        parents[findParent(b)] = findParent(a);
    }

}
