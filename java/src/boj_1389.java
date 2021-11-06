// 백준 1389 - 케빈 베이컨의 6단계 법칙

import java.util.Scanner;

public class boj_1389 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = 10000;
                }
            }
        }

        for (int m = 0; m < M; m++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            graph[A][B] = 1;
            graph[B][A] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        int answer = -1;
        int min = 10000;
        for (int i = 1; i <= N; i++) {
            int temp = 0;
            for (int j = 1; j <= N; j++) {
                temp += graph[i][j];
            }
            if (min > temp) {
                min = temp;
                answer = i;
            }
        }
        System.out.println(answer);
    }
}
