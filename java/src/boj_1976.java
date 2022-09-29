// 백준 1976 - 여행 가자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1976 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] data = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (map[i][j] == 1) {
                    union(i + 1, j + 1);
                }
            }
        }

        String answer = "YES";

        for (int i = 0; i < M - 1; i++) {
            if (find(data[i]) != find(data[i + 1])) {
                answer = "NO";
                break;
            }
        }

        System.out.println(answer);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[a] = b;
    }

    public static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

}
