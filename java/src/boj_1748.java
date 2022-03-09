// 백준 1748 - 수 이어 쓰기 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1748 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        int num = 10;
        int i = 1;
        while (true) {
            if (N / (num - 1) > 0) {
                answer += (num / 10 * 9) * i;
            } else {
                answer += (N - (num / 10 - 1)) * i;
                break;
            }
            i++;
            num *= 10;
        }

        System.out.println(answer);
    }

}
