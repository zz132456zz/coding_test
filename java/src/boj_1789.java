// 백준 1789 - 수들의 합

import java.io.*;

public class boj_1789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long S = Long.parseLong(br.readLine());

        int answer = 0;
        int i = 1;
        while(S > 0) {
            S -= i++;
            answer++;
        }

        if (S != 0) {
            answer--;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

}
