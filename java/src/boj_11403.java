// 백준 11403 - 경로 찾기

import java.util.Scanner;

public class boj_11403 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] data = new int[N][N];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int temp = scanner.nextInt();
                if (temp == 0) {
                    data[i][j] = 100000;
                } else {
                    data[i][j] = 1;
                }
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    data[i][j] = Math.min(data[i][j], data[i][k] + data[k][j]);
                }
            }
        }

        String one = "1 ";
        String zero = "0 ";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (data[i][j] == 100000) {
                    sb.append(zero);
                } else {
                    sb.append(one);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
