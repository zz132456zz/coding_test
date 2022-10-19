// 백준 4375 - 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_4375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        String line = "";
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            int cnt = 1;
            int num = 1;

            while (true) {
                num = (num % n) * 10 + 1;

                if (num == 1) {
                    answer.append(cnt).append("\n");
                    break;
                }
                cnt++;
            }
        }

        System.out.print(answer);
    }

}
