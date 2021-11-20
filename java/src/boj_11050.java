// 백준 11050 - 이항 계수 1

import java.util.Scanner;

public class boj_11050 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int answer = 1;

        for (int i = 0; i < K; i++) {
            answer *= N;
            N--;
        }
        for (int i = 1; i <= K; i++) {
            answer /= i;
        }

        System.out.println(answer);
    }
}
