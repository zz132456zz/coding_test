// 백준 6064 - 카잉 달력

import java.util.Scanner;

public class boj_6064 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            boolean flag = false;

            if (M < N) {
                int temp = M;
                M = N;
                N = temp;
                temp = x;
                x = y;
                y = temp;
            }

            for (int i = 0; i <= M; i++) {
                int a = i * M + x;

                if (a % N == y) {
                    sb.append(a + "\n");
                    flag = true;
                    break;
                } else if (a % N == 0 && y == N) {
                    sb.append(a + "\n");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                sb.append("-1\n");
            }
        }
        System.out.println(sb);
    }
}
