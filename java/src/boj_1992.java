// 백준 1992 - 쿼드트리

import java.util.Scanner;

public class boj_1992 {

    static StringBuilder sb = new StringBuilder();
    static String[] data;

    static void partition(int x, int y, int n) {
        char now = data[x].charAt(y);
        boolean flag = false;

        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (data[i].charAt(j) != now) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        if (flag) {
            sb.append("(");
            partition(x, y, n / 2);
            partition(x, y + n / 2, n / 2);
            partition(x + n / 2, y, n / 2);
            partition(x + n / 2, y + n / 2, n / 2);
            sb.append(")");
        } else {
            sb.append(now);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        data = new String[N];
        for (int i = 0; i < N; i++) {
            data[i] = scanner.next();
        }

        partition(0, 0, N);

        System.out.println(sb);
    }
}
