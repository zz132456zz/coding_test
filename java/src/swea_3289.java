// SWEA 3289 - 서로소 집합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_3289 {

    static int n;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            makeSet();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (cmd == 0) {
                    union(a, b);
                } else if (cmd == 1) {
                    sb.append(unionCheck(a, b));
                }
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void makeSet() {
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
    }

    public static int findParent(int a) {
        if (parents[a] == a) return a;
        return parents[a] = findParent(parents[a]);
    }

    public static void union(int a, int b) {
        if (findParent(a) == findParent(b)) return;
        parents[findParent(b)] = parents[findParent(a)];
    }

    public static int unionCheck(int a, int b) {
        if (findParent(a) == findParent(b)) return 1;
        return 0;
    }

}
