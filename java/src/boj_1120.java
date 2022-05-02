// 백준 1120 - 문자열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1120 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        int diff = B.length() - A.length();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= diff; i++) {
            int cnt = 0;
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt(i + j)) cnt++;
            }
            min = Math.min(min, cnt);
        }

        System.out.println(min);
    }

}
