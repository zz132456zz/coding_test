// 백준 10819 - 차이를 최대로

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10819 {
    static int N;
    static int[] choose;
    static int[] data;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        data = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        choose = new int[N];
        visited = new boolean[N];
        answer = 0;

        check(0);

        System.out.println(answer);
    }

    public static void check(int depth) {
        if (depth == N) {
            int ans = calc(choose);
            if (answer < ans) answer = ans;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                choose[depth] = data[i];
                visited[i] = true;
                check(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static int calc(int[] choose) {
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(choose[i] - choose[i + 1]);
        }
        return sum;
    }
}
