// 백준 23323 - 황소 다마고치

import java.util.Scanner;

public class boj_23323 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            long n = scanner.nextLong();
            long m = scanner.nextLong();
            long day = 0;

            while (n > 0) {
                if (n == 1) {
                    day += m + 1;
                    break;
                }
                day++;
                n /= 2;
            }
            System.out.println(day);
        }
    }
}
