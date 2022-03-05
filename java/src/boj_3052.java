// 백준 3052 - 나머지

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_3052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] remain = new int[42];
        int answer = 0;

        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            remain[num % 42] = 1;
        }

        for (int i = 0; i < 42; i++) {
            answer += remain[i];
        }

        System.out.println(answer);
    }

}
