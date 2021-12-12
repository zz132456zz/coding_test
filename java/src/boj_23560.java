// 백준 23560 - 약

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class boj_23560 {

    static int answer = 0;

    static void recur(Deque<Integer> deque, int time) {
        if (deque.size() == 0) {
            answer++;
            return;
        }

        if (time == 1) {
            if(deque.getFirst() == 1) {
                deque.pollFirst();
                recur(deque, 2);
                deque.offerFirst(1);
            }
            if (deque.getLast() == 1) {
                deque.pollLast();
                recur(deque, 2);
                deque.offerLast(1);
            }
        } else if (time == 2) {
            if(deque.getFirst() == 0) {
                deque.pollFirst();
                recur(deque, 3);
                deque.offerFirst(0);
            }
            if (deque.getLast() == 0) {
                deque.pollLast();
                recur(deque, 3);
                deque.offerLast(0);
            }
        } else {
            if(deque.getFirst() == 1) {
                deque.pollFirst();
                recur(deque, 1);
                deque.offerFirst(1);
            }
            if (deque.getLast() == 1) {
                deque.pollLast();
                recur(deque, 1);
                deque.offerLast(1);
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            deque.offer(1);
            deque.offer(0);
            deque.offer(1);
        }

        recur(deque, 1);

        bw.write((answer / 2) + "\n");
        bw.flush();
        bw.close();
    }

}
