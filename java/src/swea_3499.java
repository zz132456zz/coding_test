// SWEA 3499 - 퍼펙트 셔플

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_3499 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            Queue<String> queue = new LinkedList<>();
            int half = (N + 1) / 2;
            for (int i = 0; i < half; i++) {
                queue.offer(st.nextToken());
            }

            bw.write("#" + tc);
            while (st.hasMoreTokens()) {  // 받아올 수가 있으면
                bw.write(" " + queue.poll());  // 큐에서 하나 뽑고
                bw.write(" " + st.nextToken());  // 다음거 받고
            }
            if (!queue.isEmpty()) bw.write(" " + queue.poll());
            bw.newLine();

//			bw.write("#" + tc);
//			for (int i = 0; i < half - 1; i++) {
//				bw.write(" " + queue.poll());
//				bw.write(" " + st.nextToken());
//			}
//			if (!queue.isEmpty()) bw.write(" " + queue.poll());
//			if (st.hasMoreTokens()) bw.write(" " + st.nextToken());
//			bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
