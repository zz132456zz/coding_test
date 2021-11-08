// 백준 9020 - 골드바흐의 추측

import java.util.Scanner;

public class boj_9020 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        StringBuilder sb = new StringBuilder();

        boolean[] prime = new boolean[10001];
        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i <= (int) Math.pow(10000, 0.5); i++) {
            if (prime[i] == false) {
                int j = 2;
                while (i * j <= 10000) {
                    prime[i * j] = true;
                    j++;
                }
            }
        }

        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int temp = n / 2;

            for (int i = 0; i < 10000; i++) {
                if (prime[temp - i] == false && prime[temp + i] == false) {
                    sb.append(temp - i);
                    sb.append(" ");
                    sb.append(temp + i);
                    sb.append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
