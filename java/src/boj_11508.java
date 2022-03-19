// 백준 11508 - 2+1 세일

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_11508 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(data);
        int answer = 0;

        for (int i = N - 1, j = 1; i >= 0; i--, j++) {
            if (j % 3 == 0) continue;
            answer += data[i];
        }

        System.out.println(answer);
    }

}
