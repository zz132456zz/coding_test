// 백준 13140 - Hello World! - 메모리 초과..

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_13140 {

    static int N;
    static int[] result = new int[7];
    static boolean[] visited = new boolean[10];
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        permutation(0);

        if (flag) {
            answer.append("  ").append(result[2]).append(result[1]).append(result[3]).append(result[3]).append(result[4]).append("\n");
            answer.append("+ ").append(result[6]).append(result[4]).append(result[5]).append(result[3]).append(result[0]).append("\n");
            answer.append("-------\n");
            if (Integer.toString(N).length() == 5) answer.append(" ");
            answer.append(" ").append(N);
        } else {
            answer.append("No Answer");
        }

        System.out.println(answer);
    }

    public static void permutation(int depth) {
        if (depth == 7) {
            if (check()) flag = true;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (i == 0 && (depth == 2 || depth == 6)) continue;
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                permutation(depth + 1);
                if (flag) return;
                visited[i] = false;
            }
        }
    }

    public static boolean check() {
        StringBuilder hello = new StringBuilder();
        StringBuilder world = new StringBuilder();
        hello.append(result[2]).append(result[1]).append(result[3]).append(result[3]).append(result[4]);
        world.append(result[6]).append(result[4]).append(result[5]).append(result[3]).append(result[0]);
        if (Integer.parseInt(hello.toString()) + Integer.parseInt(world.toString()) == N) return true;
        return false;
    }

}
