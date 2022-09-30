// SWEA 1989 - 초심자의 회문 검사

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String str1 = br.readLine();
            StringBuilder temp = new StringBuilder(str1);
            temp.reverse();

            sb.append("#").append(tc).append(" ");

            if (str1.equals(temp.toString())) {
                sb.append(1);
            } else {
                sb.append(0);
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }

}
