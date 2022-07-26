// 70/100

public class programmers_test_1_4 {

    static int N;

    public static int solution(int[][] beginning, int[][] target) {
        int answer = 0;

        N = beginning.length;

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (beginning[i][j] == target[i][j]) {
                    map[i][j] = 1;
                }
            }
        }

        boolean[] visitedR = new boolean[N];
        boolean[] visitedC = new boolean[N];

        while (!fin(map)) {
            int[] cur = find(map);

            if (cur[0] == 0) {
                if (visitedR[cur[1]]) {
                    answer = -1;
                    break;
                }
                visitedR[cur[1]] = true;
            } else if (cur[0] == 1) {
                if (visitedC[cur[1]]) {
                    answer = -1;
                    break;
                }
                visitedC[cur[1]] = true;
            }

            flip(cur, map);

            answer++;
        }

        return answer;
    }

    public static void flip(int[] cur, int[][] map) {
        if (cur[0] == 0) {
            for (int i = 0; i < N; i++) {
                map[cur[1]][i] += 1;
                map[cur[1]][i] %= 2;
            }
        } else if (cur[0] == 1) {
            for (int i = 0; i < N; i++) {
                map[i][cur[1]] += 1;
                map[i][cur[1]] %= 2;
            }
        }
    }

    public static boolean fin(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[] find(int[][] map) {
        int max = 0;
        int r_c = -1;
        int idx = -1;

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) cnt++;
            }
            if (max < cnt) {
                max = cnt;
                r_c = 0;
                idx = i;
            }
        }

        for (int j = 0; j < N; j++) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (map[i][j] == 0) cnt++;
            }
            if (max < cnt) {
                r_c = 1;
                idx = j;
            }
        }

        return new int[] {r_c, idx};
    }

    public static void main(String[] args) {
//        int[][] beginning = {{0, 1, 0, 0, 0}, {1, 0, 1, 0, 1}, {0, 1, 1, 1, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
//        int[][] target = {{0, 0, 0, 1, 1}, {0, 0, 0, 0, 1}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}};
        int[][] beginning = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int[][] target = {{1, 0, 1}, {0, 0, 0}, {0, 0, 0}};

        int result = solution(beginning, target);

        System.out.println(result);
    }

}
