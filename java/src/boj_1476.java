// 백준 1476 - 날짜 계산

import java.io.*;
import java.util.StringTokenizer;

public class boj_1476 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int e = 1;
        int s = 1;
        int m = 1;

        int answer = 1;
        while (true) {
            if (E == e && S == s && M == m) {
                break;
            }

            if (e == 15) {
                e = 1;
            } else {
                e++;
            }

            if (s == 28) {
                s = 1;
            } else {
                s++;
            }

            if (m == 19) {
                m = 1;
            } else {
                m++;
            }

            answer++;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

}
