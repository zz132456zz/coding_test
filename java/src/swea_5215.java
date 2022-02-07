// SWEA 5215 - 햄버거 다이어트

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class swea_5215 {
    static int MAX;
    static int N, L;
    static int[][] pick;
    static int[][] material;

    public static void combination(int cnt, int start, int n) {
        if (cnt == n) {
            int sumScore = 0;
            int sumCalorie = 0;
            for (int i = 0; i < n; i++) {
                sumScore += pick[i][0];
                sumCalorie += pick[i][1];
            }
            if (sumCalorie <= L && sumScore > MAX) {
                MAX = sumScore;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            pick[cnt] = material[i];
            combination(cnt + 1, i + 1, n);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            material = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                material[i][0] = Integer.parseInt(st.nextToken());
                material[i][1] = Integer.parseInt(st.nextToken());
            }

            MAX = Integer.MIN_VALUE;
            for (int i = 1; i <= N; i++) {
                pick = new int[i][2];
                combination(0, 0, i);
            }

            bw.write("#" + tc + " " + MAX + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
