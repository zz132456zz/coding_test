// 프로그래머스 12923 - 숫자 블록

import java.util.Arrays;

public class programmers_12923 {

    public static int[] solution(long begin, long end) {
        int N = (int) (end - begin + 1);
        int[] answer = new int[N];
        Arrays.fill(answer, 1);
        if (begin == 1) answer[0] = 0;

        for (int i = 0; i < N; i++) {
            int cur = (int) begin + i;

            int idx = (int) Math.sqrt(cur);
            for (int j = 2; j <= idx; j++) {
                if (cur % j == 0) {
                    if (cur / j > 10000000) continue;
                    answer[i] = cur / j;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        long begin = 1;
        long end = 10;
        int[] result = solution(begin, end);

        System.out.println(Arrays.toString(result));
    }

}
