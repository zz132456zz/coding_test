// 소프티어 624 - [21년 재직자 대회 예선] 전광판

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class softeer_624 {

    static boolean[][] num = {
        {true, true, true, false, true, true, true},        // 0
        {false, false, true, false, false, true, false},    // 1
        {true, false, true, true, true, false, true},       // 2
        {true, false, true, true, false, true, true},       // 3
        {false, true, true, true, false, true, false},      // 4
        {true, true, false, true, false, true, true},       // 5
        {true, true, false, true, true, true, true},        // 6
        {true, true, true, false, false, true, false},      // 7
        {true, true, true, true, true, true, true},         // 8
        {true, true, true, true, false, true, true},        // 9
        {false, false, false, false, false, false, false}   // off
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int[] arrA = new int[5];
            int[] arrB = new int[5];
            Arrays.fill(arrA, 10);
            Arrays.fill(arrB, 10);

            int idx = 0;
            while (A > 0) {
                arrA[idx] = A % 10;
                idx++;
                A /= 10;
            }

            idx = 0;
            while (B > 0) {
                arrB[idx] = B % 10;
                idx++;
                B /= 10;
            }

            int answer = 0;
            for (int i = 0; i < 5; i++) {
                boolean[] switchA = num[arrA[i]];
                boolean[] switchB = num[arrB[i]];

                for (int j = 0; j < 7; j++) {
                    if (switchA[j] != switchB[j]) answer++;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
