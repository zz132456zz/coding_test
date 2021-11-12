// 백준 1085 - 직사각형에서 탈출

import java.util.Scanner;

public class boj_1085 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int w = scanner.nextInt();
        int h = scanner.nextInt();
        int answer = 1000;

        if (answer > x) { answer = x; }
        if (answer > y) { answer = y; }
        if (answer > w - x) { answer = w - x; }
        if (answer > h - y) { answer = h - y; }

        System.out.println(answer);
    }
}
