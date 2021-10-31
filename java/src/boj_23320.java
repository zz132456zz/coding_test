// 백준 23320 - 홍익 절대평가

import java.util.Scanner;

public class boj_23320 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = scanner.nextInt();
        }
        int X = scanner.nextInt();
        int Y = scanner.nextInt();

        int relative = N * X / 100;
        int absolute = 0;

        for (int i = 0; i < N; i++) {
            if (data[i] >= Y) {
                absolute++;
            }
        }

        System.out.print(relative);
        System.out.print(" ");
        System.out.println(absolute);
    }

}
