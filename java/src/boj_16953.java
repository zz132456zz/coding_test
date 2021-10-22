// 백준 16953 - A -> B

import java.util.Scanner;

public class boj_16953 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int answer = 0;

        while (true) {
            if (A == B) {
                System.out.println(answer + 1);
                break;
            } else if (A > B) {
                System.out.println(-1);
                break;
            } else {
                if (B % 10 == 1) {
                    B /= 10;
                } else if (B % 2 == 0) {
                    B /= 2;
                } else {
                    System.out.println(-1);
                    break;
                }
            }
            answer += 1;
        }

    }

}
