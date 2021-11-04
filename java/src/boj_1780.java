// 백준 1780 - 종이의 개수

import java.util.Scanner;

public class boj_1780 {

    static int minusOne = 0;
    static int zero = 0;
    static int one = 0;
    static int[][] data;

    static void partition(int x, int y, int N) {
        boolean flag = false;
        int temp = data[x][y];

        if (N == 1) {
            if (temp == -1) {
                minusOne++;
            } else if (temp == 0) {
                zero++;
            } else if (temp == 1) {
                one++;
            }
            return;
        }

        for (int i = x; i < x + N; i++) {
            for (int j = y; j < y + N; j++) {
                if (data[i][j] != temp) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        if (flag) {
            int n = N / 3;
            partition(x, y, n);
            partition(x, y + n, n);
            partition(x, y + n * 2, n);
            partition(x + n, y, n);
            partition(x + n, y + n, n);
            partition(x + n, y + n * 2, n);
            partition(x + n * 2, y, n);
            partition(x + n * 2, y + n, n);
            partition(x + n * 2, y + n * 2, n);
        } else {
            if (temp == -1) {
                minusOne++;
            } else if (temp == 0) {
                zero++;
            } else if (temp == 1) {
                one++;
            }
            return;
        }
        return;
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

        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
    }

}
