// 백준 2559 - 수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2559 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        for (int i = 0; i < K; i++) {
            sum += data[i];
        }

        int max = sum;

        for (int i = K; i < N; i++) {
            sum += data[i];
            sum -= data[i - K];
            if (max < sum) max = sum;
        }

        System.out.println(max);
    }

}
