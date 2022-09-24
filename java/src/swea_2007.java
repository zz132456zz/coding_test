// SWEA 2207 - 패턴 마디의 길이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2007 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String str = br.readLine();
            int answer = 0;

            for (int i = 1; i <= 10; i++) {
                String temp = str.substring(0, i);
                if (str.equals(makeString(temp))) {
                    answer = i;
                    break;
                }
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

    public static String makeString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            sb.append(str.charAt(i % str.length()));
        }

        return sb.toString();
    }

}
