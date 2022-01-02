// 백준 4796 - 캠핑

import java.io.*;
import java.util.StringTokenizer;

public class boj_4796 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            if (L == 0 && P == 0 && V == 0) {
                break;
            }

            int answer = V / P * L;
            answer += V % P >= L ? L : V % P % L;

            bw.write("Case " + i + ": " + answer + "\n");
        }

        bw.flush();
        bw.close();
    }

}
