// SWEA 4406 - 모음이 보이지 않는 사람

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_4406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String data = br.readLine();
            StringBuilder answer = new StringBuilder();

            for (int i = 0; i < data.length(); i++) {
                char c = data.charAt(i);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') continue;
                answer.append(c);
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
