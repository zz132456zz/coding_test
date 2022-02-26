// 백준 1021 - 회전하는 큐

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1021 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] data = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        for (int i = 0; i < M; i++) {
            int searchNum = data[i];

            int min = Integer.MAX_VALUE;
            int cnt = 0;
            boolean left = true;

            for (int j = 0, size = queue.size(); j < size; j++) {
                int num = queue.pollFirst();
                if (num == searchNum) {
                    if (cnt < min) {
                        min = cnt;
                        left = true;
                    }
                }
                queue.addLast(num);
                cnt++;
            }

            cnt = 0;
            for (int j = 0, size = queue.size(); j < size; j++) {
                cnt++;
                int num = queue.pollLast();
                if (num == searchNum) {
                    if (cnt < min) {
                        min = cnt;
                        left = false;
                    }
                }
                queue.addFirst(num);
            }

            if (min == 0) {
                queue.poll();
            } else if (left) {
                for (int j = 0; j < min; j++) {
                    queue.addLast(queue.pollFirst());
                    answer++;
                }
                queue.poll();
            } else {
                for (int j = 0; j < min; j++) {
                    queue.addFirst(queue.pollLast());
                    answer++;
                }
                queue.poll();
            }
        }

        System.out.println(answer);
    }

}
