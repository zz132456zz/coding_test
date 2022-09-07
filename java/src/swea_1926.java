// SWEA 1926 - 간단한 369게임

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1926 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String s = Integer.toString(i);
            boolean flag = true;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '3' || c == '6' || c == '9') {
                    answer.append("-");
                    flag = false;
                }
            }

            if (flag) answer.append(i);

            answer.append(" ");
        }

        System.out.println(answer);
    }

}
