// SWEA 1289 - 원재의 메모리 복구하기

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class swea_1289 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            char now = '0';
            int cnt = 0;

            char[] data = br.readLine().toCharArray();
            for (char c : data) {
                if (c != now) {
                    cnt++;
                    now = c;
                }
            }

            answer.append("#" + t + " " + cnt + "\n");
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }

}
