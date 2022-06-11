// 프로그래머스 87946 - 피로도

public class programmers_87946 {

    static int d;
    static int max;

    public static int solution(int k, int[][] dungeons) {
        d = dungeons.length;
        max = 0;

        dfs(0, new boolean[d], k, dungeons, 0);

        return max;
    }

    public static void dfs(int depth, boolean[] visited, int k, int[][] dungeons, int cnt) {
        if (depth == d) {
            if (max < cnt) max = cnt;
            return;
        }

        for (int i = 0; i < d; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (dungeons[i][0] <= k) {
                    dfs(depth + 1, visited, k - dungeons[i][1], dungeons, cnt + 1);
                } else {
                    dfs(depth + 1, visited, k, dungeons, cnt);
                }
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int result = solution(k, dungeons);

        System.out.println(result);
    }

}
