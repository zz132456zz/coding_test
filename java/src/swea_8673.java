// SWEA 8673 - 코딩 토너먼트1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_8673 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int answer = 0;
            int K = Integer.parseInt(br.readLine());
            int N = (int) Math.pow(2, K);
            Queue<Integer> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }

            while (queue.size() != 1) {
                int W1 = queue.poll();
                int W2 = queue.poll();
                answer += Math.abs(W1 - W2);
                queue.offer(Math.max(W1, W2));
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
