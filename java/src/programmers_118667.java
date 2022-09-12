// 프로그래머스 118667 - 두 큐 합 같게 만들기

import java.util.LinkedList;
import java.util.Queue;

public class programmers_118667 {

    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        int N = queue1.length;
        int sum = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long q1Sum = 0;
        long q2Sum = 0;

        for (int i = 0; i < N; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            q1Sum += queue1[i];
            q2Sum += queue2[i];
        }

        while (true) {
            if (q1Sum < q2Sum) {
                q1Sum += q2.peek();
                q2Sum -= q2.peek();
                q1.add(q2.poll());
            } else if (q1Sum > q2Sum) {
                q1Sum -= q1.peek();
                q2Sum += q1.peek();
                q2.add(q1.poll());
            } else {
                break;
            }
            answer++;
            if (answer > N * 4) return -1;
        }

        return answer;
    }

    public static void main(String[] args) {
//        int[] queue1 = {3, 2, 7, 2};
//        int[] queue2 = {4, 6, 5, 1};
        int[] queue1 = {1, 1};
        int[] queue2 = {1, 5};
        int result = solution(queue1, queue2);

        System.out.println(result);
    }

}
