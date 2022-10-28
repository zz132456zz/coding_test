// SWEA 10570 - 제곱 팰린드롬 수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_10570 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= 31; i++) {
                if (A > i * i || i * i > B) continue;
                if (isPalindrome(i)) answer++;
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

    public static boolean isPalindrome(int N) {
        int N2 = N * N;
        StringBuilder NtoStr = new StringBuilder(Integer.toString(N));
        StringBuilder N2toStr = new StringBuilder(Integer.toString(N2));

        if (!NtoStr.reverse().toString().equals(Integer.toString(N))) return false;
        if (!N2toStr.reverse().toString().equals(Integer.toString(N2))) return false;

        return true;
    }

}
