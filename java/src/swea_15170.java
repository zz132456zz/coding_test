// SWEA 15170 - 낚시터 자리잡기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_15170 {

    static int N;
    static int[][] data;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            data = new int[3][2];
            for (int i = 0; i < 3; i++) {
                st = new StringTokenizer(br.readLine());
                data[i][0] = Integer.parseInt(st.nextToken()) - 1;
                data[i][1] = Integer.parseInt(st.nextToken());
            }
            min = Integer.MAX_VALUE;

            calc(0, new boolean[3], true, new boolean[N], 0);
            calc(0, new boolean[3], false, new boolean[N], 0);

            answer.append("#").append(t).append(" ").append(min).append("\n");
        }

        System.out.print(answer);
    }

    public static void calc(int d, boolean[] checked, boolean isLeft, boolean[] visited, int sum) {
        if (d == 3) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (checked[i]) continue;
            boolean[] oldVisited = visited.clone();
            int curSum = 0;

            int loc = data[i][0];
            int cnt = data[i][1];

            int idx = 0;
            int mul = isLeft ? -1 : 1;
            while (true) {
                if (0 <= (loc + idx * mul) && (loc + idx * mul) < N && !visited[loc + idx * mul]) {
                    visited[loc + idx * mul] = true;
                    curSum += idx + 1;
                    cnt--;
                    if (cnt == 0) break;
                }
                if (0 <= (loc + idx * mul * -1) && (loc + idx * mul * -1) < N &&!visited[loc + idx * mul * -1]) {
                    visited[loc + idx * mul * -1] = true;
                    curSum += idx + 1;
                    cnt--;
                    if (cnt == 0) break;
                }
                idx++;
            }

            checked[i] = true;
            calc(d + 1, checked, true, visited.clone(), sum + curSum);
            calc(d + 1, checked, false, visited.clone(), sum + curSum);
            checked[i] = false;
            visited = oldVisited;
        }
    }

}
