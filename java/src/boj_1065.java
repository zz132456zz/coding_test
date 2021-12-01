// 백준 1065 - 한수

import java.io.*;

public class boj_1065 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        if (N < 100) {
            bw.write(N + "\n");
        } else {
            int answer = 99;
            for (int i = 100; i <= N; i++) {
                String temp = Integer.toString(i);
                if (temp.charAt(0) - temp.charAt(1) == temp.charAt(1) - temp.charAt(2)) {
                    answer++;
                }
            }
            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
    }

}
