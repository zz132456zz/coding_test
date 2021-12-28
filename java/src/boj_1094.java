// 백준 1094 - 막대기

import java.io.*;

public class boj_1094 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int X = Integer.parseInt(br.readLine());
        String binaryString = Integer.toBinaryString(X);

        int answer = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                answer++;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

}
