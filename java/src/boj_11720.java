// 백준 11720 - 숫자의 합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String num = br.readLine();

        int answer = 0;

        for (int i = 0; i < N; i++) {
            answer += num.charAt(i) - '0';
        }

        System.out.println(answer);
    }

}
