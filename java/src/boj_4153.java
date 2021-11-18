// 백준 4153 - 직각삼각형

import java.util.Arrays;
import java.util.Scanner;

public class boj_4153 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int[] side = new int[3];
            for (int i = 0; i < 3; i++) {
                side[i] = scanner.nextInt();
            }
            Arrays.sort(side);

            if (side[0] == 0) {
                break;
            } else {
                if (Math.pow(side[0], 2) + Math.pow(side[1], 2) == Math.pow(side[2], 2)) {
                    System.out.println("right");
                } else {
                    System.out.println("wrong");
                }
            }
        }
    }
}
