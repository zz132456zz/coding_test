// SWEA 1206 - View

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1206 {

    static int[] data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            data = new int[N + 4];
            for (int i = 2; i < N + 2; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }
            int answer = 0;

            for (int i = 2; i < N + 2; i++) {
                answer += calc(i);
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

    public static int calc(int idx) {
        int left = Math.max(data[idx - 1], data[idx - 2]);
        int right = Math.max(data[idx + 1], data[idx + 2]);
        int max = Math.max(left, right);

        if (data[idx] <= max) return 0;
        else return data[idx] - max;
    }

}
