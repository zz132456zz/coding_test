// SWEA 1225 - 암호생성기

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1225 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String T;
        while((T = br.readLine()) != null) {
            int tc = Integer.parseInt(T);
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < 8; i++) {
                q.offer(Integer.parseInt(st.nextToken()));
            }

            flag : while (true) {
                for (int i = 1; i <= 5; i++) {
                    if (q.peek() - i <= 0) {
                        q.poll();
                        q.offer(0);
                        break flag;
                    }
                    q.offer(q.poll() - i);
                }
            }

            bw.write("#" + tc);
            for (int i : q) {
                bw.write(" " + i);
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
