// 백준 2675 - 문자열 반복

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2678 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String S = st.nextToken();

            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                for (int j = 0; j < R; j++) {
                    sb.append(c);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

}
