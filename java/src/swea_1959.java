// SWEA 1959 - 두 개의 숫자열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1959 {
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            answer = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] dataA = new int[N];
            int[] dataB = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                dataA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                dataB[i] = Integer.parseInt(st.nextToken());
            }

            if (N > M) {
                check(dataA, dataB);
            } else {
                check(dataB, dataA);
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

    public static void check(int[] l, int[] s) {
        for (int i = 0; i <= l.length - s.length; i++) {
            int sum = 0;
            for (int j = 0; j < s.length; j++) {
                sum += l[i + j] * s[j];
            }
            if (sum > answer) answer = sum;
        }
    }

}
