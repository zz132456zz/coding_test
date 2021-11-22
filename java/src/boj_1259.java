// 백준 1259 - 팰린드롬수

import java.util.Scanner;

public class boj_1259 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.next();
        StringBuilder sb = new StringBuilder();

        while (!data.equals("0")) {
            boolean flag = true;
            int len = data.length();
            for (int i = 0; i < len; i++) {
                if (data.charAt(i) != data.charAt(len - i - 1)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }

            data = scanner.next();
        }

        System.out.println(sb);
    }
}
