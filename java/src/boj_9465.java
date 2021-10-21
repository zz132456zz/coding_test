// 백준 9465 - 스티커

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9465 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(bf.readLine());
            int[] data1 = new int[n];
            int[] data2 = new int[n];
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                data1[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                data2[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp1 = new int[n];
            int[] dp2 = new int[n];

            dp1[0] = data1[0];
            dp2[0] = data2[0];
            if (n > 1){
                dp1[1] = data1[1] + data2[0];
                dp2[1] = data2[1] + data1[0];
                for (int i = 2; i < n; i++) {
                    dp1[i] = Math.max(data1[i] + dp2[i - 1], data1[i] + dp2[i - 2]);
                    dp2[i] = Math.max(data2[i] + dp1[i - 1], data2[i] + dp1[i - 2]);
                }
            }

            System.out.println(Math.max(dp1[n - 1], dp2[n - 1]));
        }

    }

}
