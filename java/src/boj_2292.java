// 백준 2292 - 벌집

import java.util.Scanner;

public class boj_2292 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int answer = 1;
        int now = 1;

        while (N > now) {
            now += answer++ * 6;
        }

        System.out.println(answer);
    }
}
