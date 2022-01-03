// 백준 1059 - 좋은 구간

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1059 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int L = Integer.parseInt(br.readLine());
        int[] S = new int[L + 1];
        S[0] = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= L; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        int n = Integer.parseInt(br.readLine());

        Arrays.sort(S);

        int answer = 0;
        int left = -1;
        int right = -1;
        for (int i = 0; i < L; i++) {
            if (S[i] < n && n < S[i + 1]) {
                left = S[i];
                right = S[i + 1];
            }
        }

        if (!(left == -1 && right == -1)) {
            for (int i = left + 1; i <= n; i++) {
                for (int j = n; j < right; j++) {
                    answer++;
                }
            }
            answer--;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

}
