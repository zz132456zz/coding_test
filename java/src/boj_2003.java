// 백준 2003 - 수들의 합 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] data = new int[N + 5];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int sum = data[0];
        int idxLeft = 0;
        int idxRight = 0;
        while (true) {
            if (sum == M) {
                answer++;
                sum += data[++idxRight];
                sum -= data[idxLeft++];
            } else if (sum < M) {
                sum += data[++idxRight];
            } else {
                sum -= data[idxLeft++];
            }

            if (idxRight == N) break;
            if (idxLeft == N) break;
        }

        System.out.println(answer);
    }

}
