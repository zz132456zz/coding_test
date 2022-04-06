// 백준 17471 - 게리맨더링

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_17471 {

    static int N;
    static int[] population;
    static int[][] map;
    static boolean[] visited;
    static int min;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());  // 구역의 수

        population = new int[N + 1];  // 구역의 인구수
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                map[i][Integer.parseInt(st.nextToken())] = 1;
            }
        }

        visited = new boolean[N + 1];
        min = Integer.MAX_VALUE;

        subset(1);

        if (min == Integer.MAX_VALUE) {
            min = -1;
        }

        System.out.println(min);
    }

    public static void subset(int depth) {
        if (depth == N) {
            calc();
            return;
        }
        visited[depth] = true;
        subset(depth + 1);
        visited[depth] = false;
        subset(depth + 1);
    }

    public static void calc() {
        ArrayList<Integer> part1 = new ArrayList<>();
        ArrayList<Integer> part2 = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                part1.add(i);
            } else {
                part2.add(i);
            }
        }

        if (part1.size() == 0 || part2.size() == 0) {
            return;
        }

        if (isSameParent(part1) && isSameParent(part2)) {
            int sum = 0;
            for (int idx : part1) {
                sum += population[idx];
            }
            for (int idx : part2) {
                sum -= population[idx];
            }
            min = Math.min(min, Math.abs(sum));
        }
    }

    public static int find(int x) {
        if (x == parent[x])
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    public static void union(int r, int c) {
        r = find(r);
        c = find(c);
        if (r != c) {
            if (r < c) parent[c] = r;
            else parent[r] = c;
        }
    }

    public static boolean isSameParent(ArrayList<Integer> part) {
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i : part) {
            for (int j : part) {
                if (i != j && map[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        for (int i = 0; i < part.size() - 1; i++) {
            if (find(parent[part.get(i)]) != find(parent[part.get(i + 1)])) {
                return false;
            }
        }

        return true;
    }

}
