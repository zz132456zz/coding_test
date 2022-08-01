// 백준 1138 - 한 줄로 서기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1138 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            int now = i + 1;
            int cnt = 0;

            for (int j = 0; j < N; j++) {
                if (cnt == data[i]) {
                    if (answer[j] != 0) continue;
                    answer[j] = now;
                    break;
                }

                if (answer[j] == 0) {
                    cnt++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }

}
