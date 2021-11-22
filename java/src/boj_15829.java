// 백준 15829 - Hashing

import java.util.Scanner;

public class boj_15829 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int L = scanner.nextInt();
        String data = scanner.next();
        long answer = 0;

        for (int i = 0; i < L; i++) {
            long temp = data.charAt(i) - 'a' + 1;
            long temp2 = 1;
            for (int j = 0; j < i; j++) {
                temp2 = temp2 * 31 % 1234567891;
            }
            answer += temp * temp2;
            answer %= 1234567891;
        }

        System.out.println(answer);
    }
}
