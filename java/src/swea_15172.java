// SWEA 15172 - 헌터

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class swea_15172 {

    static int N;
    static int[][] map;
    static Map<Integer, int[]> mon;
    static int size;
    static int min;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            mon = new HashMap<>();

            int max = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, map[i][j]);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > 0) { // 몬스터
                        mon.put(map[i][j], new int[] {i, j});
                    } else if (map[i][j] < 0) { // 집
                        mon.put(map[i][j] * -1 + max, new int[] {i, j});
                    }
                }
            }

            size = mon.size() / 2;
            result = new int[mon.size()];
            min = Integer.MAX_VALUE;

            permu(0, new boolean[mon.size() + 1]);

            answer.append("#").append(t).append(" ").append(min).append("\n");
        }

        System.out.print(answer);
    }

    public static void permu(int d, boolean[] visited) {
        if (d == mon.size()) {
            min = Math.min(min, calc());
            return;
        }

        for (int i = 1; i <= mon.size(); i++) {
            if (visited[i]) continue;

            if (i > size) {
                if (visited[i - size]) {
                    visited[i] = true;
                    result[d] = i;
                    permu(d + 1, visited);
                    visited[i] =false;
                }
            } else {
                visited[i] = true;
                result[d] = i;
                permu(d + 1, visited);
                visited[i] = false;
            }
        }
    }

    public static int calc() {
        int[] hunter = new int[] {0, 0};
        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            int[] cur = mon.get(result[i]);
            sum += Math.abs(hunter[0] - cur[0]);
            sum += Math.abs(hunter[1] - cur[1]);
            hunter = new int[] {cur[0], cur[1]};
        }

        return sum;
    }

}
