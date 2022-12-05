// SWEA 5356 - 의석이의 세로로 말해요

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_5356 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder answer = new StringBuilder();
            String[] data = new String[5];
            for (int i = 0; i < 5; i++) {
                data[i] = br.readLine();
            }

            int idx = 0;
            while (idx < 15) {
                for (int i = 0; i < 5; i++) {
                    if (data[i].length() > idx) {
                        answer.append(data[i].charAt(idx));
                    }
                }
                idx++;
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
