// 백준 1052 - 물병

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        while (true) {
            int cnt = 0;
            char[] NtoBinary = Integer.toBinaryString(N).toCharArray();
            for (char c : NtoBinary) {
                if (c == '1') cnt++;
            }

            if (cnt <= K) {
                break;
            }

            answer++;
            N++;
        }

        System.out.println(answer);
    }

}
