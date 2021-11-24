// 백준 11866 - 요세푸스 문제 0

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        bw.write("<");
        while (true) {
            for (int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }
            if (q.size() != 1) {
                bw.write(q.poll() + ", ");
            } else {
                bw.write(q.poll() + "");
                break;
            }
        }
        bw.write(">");

        bw.flush();
        bw.close();
    }
}
