// 백준 8958 - OX퀴즈

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_8958 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            String str = br.readLine();
            int now = 0;
            int sum = 0;

            for (int i = 0, len = str.length(); i < len; i++) {
                if (str.charAt(i) == 'O') {
                    sum += ++now;
                } else {
                    now = 0;
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }

}
