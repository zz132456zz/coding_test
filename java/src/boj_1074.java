// 백준 - 1074 - Z

import java.util.Scanner;

public class boj_1074 {

    static int N;
    static int r;
    static int c;
    static int answer = 0;

    static void partition(int count, int N, int x, int y) {
        if (x == r && y == c) {
            answer = count;
            return;
        }

        int num = N / 2;
        if (r < x + num && c < y + num) {
            partition(count, num, x, y);
            return;
        }
        if (r < x + num && y + num <= c) {
            partition(count + (num * num), num, x, y + num);
            return;
        }
        if (x + num <= r && c < y + num) {
            partition(count + (num * num * 2), num, x + num, y);
            return;
        }
        if (x + num <= r && y +num <= c) {
            partition(count + (num * num * 3), num, x + num, y + num);
            return;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        r = scanner.nextInt();
        c = scanner.nextInt();

        int size = (int) Math.pow(2, N);
        int count = 0;

        partition(count, size, 0, 0);

        System.out.println(answer);
    }

}
