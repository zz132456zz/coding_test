// 백준 2447 - 별 찍기 - 10

import java.io.*;
import java.util.Arrays;

public class boj_2447 {

    static String[] answer;
    static int N;

    public static void recur(int x, int y, int len, boolean isPass) {
        int num = len / 3;

        if (len == 1) {
            if (isPass) {
                answer[x] += ' ';
            } else {
                answer[x] += '*';
            }
            return;
        }

        recur(x, y, num, false | isPass);
        recur(x, y + num, num, false | isPass);
        recur(x, y + num * 2, num, false | isPass);
        recur(x + num, y, num, false | isPass);
        recur(x + num, y + num, num, true | isPass);
        recur(x + num, y + num * 2, num, false | isPass);
        recur(x + num * 2, y, num, false | isPass);
        recur(x + num * 2, y + num, num, false | isPass);
        recur(x + num * 2, y + num * 2, num, false | isPass);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        answer = new String[N];
        Arrays.fill(answer, "");

        recur(0, 0, N, false);

        for (int i = 0; i < N; i++) {
            bw.write(answer[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

}
