// 백준 2693 - N번째 큰 수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2693 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int[] data = new int[10];
            for (int i = 0; i < 10; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(data);

            sb.append(data[7]).append("\n");
        }

        System.out.print(sb);
    }

}
