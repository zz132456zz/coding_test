// 백준 11654 - 소인수분해

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class boj_11653 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        List<Integer> answer = new LinkedList<>();

        int now = 2;
        while (N > 1) {
            if (N % now == 0) {
                answer.add(now);
                N /= now;
            } else {
                now++;
            }
        }

        for (int i = 0; i < answer.size(); i++) {
            bw.write(answer.get(i) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
