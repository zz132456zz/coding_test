// 백준 1461 - 도서관

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;
        int max = 0;

        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            max = Math.max(Math.abs(num), max);
            if (num >= 0) {
                plus.add(num);
            } else {
                minus.add(num);
            }
        }

        plus_flag : while (!plus.isEmpty()) {
            answer += plus.peek() * 2;

            for (int i = 0; i < M; i++) {
                plus.poll();
                if (plus.isEmpty()) break plus_flag;
            }
        }

        minus_flag : while (!minus.isEmpty()) {
            answer += Math.abs(minus.peek()) * 2;

            for (int i = 0; i < M; i++) {
                minus.poll();
                if (minus.isEmpty()) break minus_flag;
            }
        }

        System.out.println(answer - max);
    }

}
