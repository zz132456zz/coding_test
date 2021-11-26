// 백준 2839 - 설탕 배달

import java.io.*;

public class boj_2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        while (N >= 3) {
            if (N % 5 == 0) {
                answer += N / 5;
                N = 0;
            } else {
                N -= 3;
                answer++;
            }
        }

        if (N != 0) {
            answer = -1;
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

}
