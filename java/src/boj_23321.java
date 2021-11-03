// 백준 23321 - 홍익 댄스파티

import java.util.Scanner;

public class boj_23321 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = new String[5];
        for (int i = 0; i < 5; i++) {
            data[i] = scanner.next();
        }

        int len = data[0].length();
        char[][] charArr = new char[5][len];
        for (int i = 0; i < 5; i++) {
            charArr[i] = data[i].toCharArray();
        }

        for (int i = 0; i < len; i++) {
            if (charArr[1][i] == 'o') {
                charArr[0][i] = 'o';
                charArr[1][i] = 'w';
                charArr[2][i] = 'l';
                charArr[3][i] = 'n';
                charArr[4][i] = '.';
            } else if (charArr[1][i] == 'w') {
                charArr[0][i] = '.';
                charArr[1][i] = 'o';
                charArr[2][i] = 'm';
                charArr[3][i] = 'l';
                charArr[4][i] = 'n';
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(charArr[i]);
        }

    }

}
