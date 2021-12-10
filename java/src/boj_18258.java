// 백준 18258 - 큐 2

import java.io.*;
import java.util.*;

public class boj_18258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                q.offer(num);
            } else if (cmd.equals("pop")) {
                if (q.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(q.poll() + "\n");
                }
            } else if (cmd.equals("size")) {
                bw.write(q.size() + "\n");
            } else if (cmd.equals("empty")) {
                if (q.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (cmd.equals("front")) {
                if (q.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(q.getFirst() + "\n");
                }
            } else if (cmd.equals("back")) {
                if (q.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(q.getLast() + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }

}
