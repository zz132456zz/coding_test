// 정올 2577 - 회전 초밥(고)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol_2577 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        int[] visited = new int[d + 1];
        int cnt = 0;
        int max = 0;
        int coupon = 0;

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k; i++) {
            if (visited[sushi[i]]++ == 0) {
                cnt++;
            }
        }

        if (visited[c] == 0) coupon = 1;

        max = cnt + coupon;

        for (int i = 0; i < N - 1; i++) {
            coupon = 0;
            int minus = sushi[i];
            int plus = sushi[(i + k) % N];

            visited[minus]--;
            if (visited[minus] == 0) {
                cnt--;
            }

            if (visited[plus] == 0) {
                cnt++;
            }
            visited[plus]++;

            if (visited[c] == 0) coupon = 1;

            if (max < cnt + coupon) max = cnt + coupon;
        }

        System.out.println(max);
    }

}
