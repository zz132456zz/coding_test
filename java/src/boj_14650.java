// 백준 14650 - 걷다보니 신천역 삼 (Small)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_14650 {

    static int N;
    static int[] choice;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        choice = new int[N];
        answer = 0;
        part(0);

        System.out.println(answer);
    }

    public static void part(int depth) {
        if (depth == N) {
            if (choice[0] == 0) return;
            int num = 0;
            int mul = 1;
            for (int i = 0; i < N; i++) {
                num += choice[i] * mul;
                mul *= 10;
            }
            if (num % 3 == 0) answer++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            choice[depth] = i;
            part(depth + 1);
        }
    }

}
