// 백준 1717 - 집합의 표현

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1717 {

    static int[] root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        root = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            root[i] = i;
        }

        for (int t = 0; t < m; t++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cmd == 0) {
                union(a, b);
            } else if (cmd == 1) {
                if (find(a) == find(b)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        System.out.print(sb);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        root[b] = a;
    }

    public static int find(int a) {
        if (root[a] == a) {
            return a;
        } else {
            return root[a] = find(root[a]);
        }
    }

}
