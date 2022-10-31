// SWEA 9317 - 석찬이의 받아쓰기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_9317 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            String str1 = br.readLine();
            String str2 = br.readLine();
            int answer = 0;

            for (int i = 0; i < N; i++) {
                if (str1.charAt(i) == str2.charAt(i)) answer++;
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
