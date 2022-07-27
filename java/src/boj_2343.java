// 백준 2343 - 기타 레슨 - 시간초과

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2343 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] data = new int[N];
        int sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
            sum += data[i];
            if (max < data[i]) max = data[i];
        }

        int left = 1;
        int right = sum;

        int mid = max > (sum / M) ? max : (sum / M);
        int answer = Integer.MAX_VALUE;

        while (true) {

            int cnt = check(data, mid, max);

            if (cnt < M) {
                System.out.println("cnt가 더 작다");
                right = mid - 1;

                mid = (left + mid) / 2;
                System.out.println(mid);
            } else if (cnt > M){
                System.out.println("cnt가 더 크다 크다 크다");
                left = mid + 1;
                mid = (right + mid) / 2;

                System.out.println(mid);
            } else {
                System.out.println("같다");
                int n = (left + mid) / 2;
                if (mid < answer) answer = mid;
                if (mid == n) break;
                mid = n;
                System.out.println(mid);
            }
        }

        System.out.println(answer);

    }

    public static int check(int[] data, int len, int max) {
        if (len < max) return Integer.MAX_VALUE;
        int cnt = 0;

        int idx = 0;
        int sum = 0;
        while (true) {
            if (sum + data[idx] > len) {
                cnt++;
                sum = 0;
            } else {
                sum += data[idx];
                idx++;
            }
            System.out.println("len : " + len);
            System.out.println(idx);

            if (idx == data.length) {
                break;
            }
        }

        return cnt + 1;
    }

}
