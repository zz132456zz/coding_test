// SWEA 1223 - 계산기2

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class swea_1223 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int tc = 1; tc <= 10; tc++) {
            int len = Integer.parseInt(br.readLine());
            char[] data = br.readLine().toCharArray();
            Stack<Character> operStack = new Stack<>();
            Queue<Character> transQueue = new LinkedList<>();

            for (char c : data) {
                if ('0' <= c && c <= '9') {
                    transQueue.offer(c);
                } else {
                    if (operStack.isEmpty()) {
                        operStack.add(c);
                    } else {
                        if (priority(c) > priority(operStack.peek())) {
                            operStack.add(c);
                        } else {
                            while (!operStack.isEmpty() && priority(c) <= priority(operStack.peek())) {
                                transQueue.offer(operStack.pop());
                            }
                            operStack.add(c);
                        }
                    }
                }
            }
            while (!operStack.isEmpty()) {
                transQueue.offer(operStack.pop());
            }

            bw.write("#" + tc + " " + calculation(transQueue) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int priority(char c) {
        return c == '+' ? 1 : 2;
    }

    public static int calculation(Queue<Character> queue) {
        Stack<Integer> numStack = new Stack<>();

        while (!queue.isEmpty()) {
            char now = queue.poll();
            if ('0' <= now && now <= '9') {
                numStack.add(now - '0');
            } else {
                if (now == '+') {
                    numStack.add(numStack.pop() + numStack.pop());
                } else if (now == '*') {
                    numStack.add(numStack.pop() * numStack.pop());
                }
            }
        }

        return numStack.pop();
    }

}
