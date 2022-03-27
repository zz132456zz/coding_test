// 백준 11170 - 0의 개수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11170 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int answer = 0;

            for (int i = N; i <= M; i++) {
                String str = Integer.toString(i);
                int len = str.length();
                for (int j = 0; j < len; j++) {
                    if (str.charAt(j) == '0') answer++;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
