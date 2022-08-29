// 백준 10974 - 모든 순열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10974 {

    static int N;
    static int[] result;
    static boolean[] visited;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        result = new int[N];
        visited = new boolean[N + 1];

        permu(0);

        System.out.print(answer);
    }

    public static void permu(int d) {
        if (d == N) {
            printResult();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            result[d] = i;
            visited[i] = true;
            permu(d + 1);
            visited[i] = false;
        }
    }

    public static void printResult() {
        for (int i = 0; i < N; i++) {
            answer.append(result[i]).append(" ");
        }
        answer.append("\n");
    }

}
