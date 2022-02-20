// 백준 2577 - 숫자의 개수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2577 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int[] answer = new int[10];

        String mul = Integer.toString(A * B * C);

        for (int i = 0; i < mul.length(); i++) {
            answer[mul.charAt(i) - '0']++;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(answer[i]);
        }
    }

}
