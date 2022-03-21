// 백준 9613 - GCD 합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_9613 {

    public static int gcd(int a, int b) {
        while (a != 0) {
            int r = b % a;
            b = a;
            a = r;
        }
        return b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(data);

            long answer = 0;

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    answer += gcd(data[i], data[j]);
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
