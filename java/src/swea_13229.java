// SWEA 13229 - 일요일

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_13229 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int answer = 0;
            String S = br.readLine();
            String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

            for (int i = 0; i < 7; i++) {
                if (S.equals(days[i])) {
                    answer = 7 - i;
                }
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
