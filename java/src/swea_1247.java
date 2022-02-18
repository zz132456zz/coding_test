// SWEA 1247 - 최적 경로

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1247 {

    static int N;

    static int[] company;
    static int[] home;
    static int[][] data;

    static boolean[] visited;
    static int[] nums;

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            company = new int[2];
            home = new int[2];
            data = new int[N][2];
            company[0] = Integer.parseInt(st.nextToken());
            company[1] = Integer.parseInt(st.nextToken());
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                data[i][0] = Integer.parseInt(st.nextToken());
                data[i][1] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[N];
            nums = new int[N];
            answer = Integer.MAX_VALUE;
            permutation(0);

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void permutation(int cnt) {
        if (cnt == N) {
            int sum = 0;

            sum += Math.abs(company[0] - data[nums[0]][0]) + Math.abs(company[1] - data[nums[0]][1]);

            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(data[nums[i]][0] - data[nums[i + 1]][0]) + Math.abs(data[nums[i]][1] - data[nums[i + 1]][1]);
            }

            sum += Math.abs(data[nums[N -1]][0] - home[0]) + Math.abs(data[nums[N - 1]][1] - home[1]);

            if (answer > sum) answer = sum;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            nums[cnt] = i;
            visited[i] = true;
            permutation(cnt + 1);
            visited[i] = false;
        }
    }

}
