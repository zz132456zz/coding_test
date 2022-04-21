// 백준 12782 - 비트 우정지수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_12782 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            String N = st.nextToken();
            String M = st.nextToken();

            int len = M.length();
            int zero = 0;
            int one = 0;

            for (int i = 0; i < len; i++) {
                if (M.charAt(i) != N.charAt(i)) {
                    if (M.charAt(i) == '1') {
                        one++;
                    } else {
                        zero++;
                    }
                }
            }

            int min = Math.min(zero, one);

            answer = zero + one - min;

            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
