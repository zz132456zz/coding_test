// 백준 9012 - 괄호

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            String PS = br.readLine();
            boolean flag = true;

            while (flag) {
                flag = false;
                if (PS.contains("()")) {
                    PS = PS.replaceAll("\\(\\)", "");
                    flag = true;
                }
            }

            if (PS.length() == 0) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb);
    }

}
