// 백준 1110 - 더하기 사이클

import java.util.Scanner;

public class boj_1110 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int cycle = 0;
        int num = N;
        while (true) {
            cycle += 1;
            num = (num % 10) * 10 + (num / 10 + num % 10) % 10;
            if (num == N) {
                break;
            }
        }
        System.out.println(cycle);

    }

}
