// 백준 2630 - 색종이 만들기

import java.util.Scanner;

public class boj_2630 {

    static int[] answer = new int[2];
    static int[][] data;

    static void partition(int x, int y, int n) {
        int color = data[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (data[i][j] != color) {
                    n /= 2;
                    partition(x, y, n);
                    partition(x + n, y, n );
                    partition(x, y + n, n);
                    partition(x + n, y + n, n);
                    return;
                }
            }
        }
        answer[color]++;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        data = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                data[i][j] = scanner.nextInt();
            }
        }

        partition(0, 0, N);

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

}
