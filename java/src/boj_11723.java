// 백준 11723 - 집합

import java.util.*;

public class boj_11723 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder answer = new StringBuilder();

        int M = Integer.parseInt(scanner.nextLine());
        int bitmask = 0;

        for (int i = 0; i < M; i++) {
            String cmd = scanner.next();
            int num;
            switch (cmd) {
                case "add":
                    num = scanner.nextInt();
                    bitmask |= 1 << num;
                    break;
                case "remove":
                    num = scanner.nextInt();
                    bitmask &= ~(1 << num);
                    break;
                case "check":
                    num = scanner.nextInt();
                    if ((bitmask & (1 << num)) == (1 << num)) {
                        answer.append("1\n");
                    } else {
                        answer.append("0\n");
                    }
                    break;
                case "toggle":
                    num = scanner.nextInt();
                    bitmask ^= 1 << num;
                    break;
                case "all":
                    bitmask = (1 << 21) - 1;
                    break;
                case "empty":
                    bitmask = 0;
                    break;
            }
        }
        System.out.println(answer);
    }
}
