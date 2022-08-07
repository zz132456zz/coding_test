// 백준 2161 - 카드1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_2161 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() != 1) {
            answer.append(queue.poll()).append(" ");
            queue.add(queue.poll());
        }

        answer.append(queue.poll());

        System.out.println(answer);
    }

}
