// 백준 1676 - 팩토리얼 0의 개수

import java.util.Scanner;

public class boj_1676 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            if (i % 125 == 0) {
                answer += 3;
            } else if (i % 25 == 0) {
                answer += 2;
            } else if (i % 5 == 0) {
                answer += 1;
            }
        }

        System.out.println(answer);
    }

}
