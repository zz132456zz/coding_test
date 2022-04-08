// 백준 1535 - 안녕

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1535 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int hp = 100;

        int N = Integer.parseInt(br.readLine());
        int[] minus = new int[N + 1];
        int[] plus = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            minus[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            plus[i] = Integer.parseInt(st.nextToken());
        }

        int[][] knapsack = new int[N + 1][hp];
        for (int i = 0; i <= N; i++) {
            knapsack[i][0] = 0;
        }
        for (int i = 0; i < hp; i++) {
            knapsack[0][i] = 0;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < hp; j++) {
                if (j >= minus[i]) {
                    if (knapsack[i - 1][j - minus[i]] + plus[i] > knapsack[i - 1][j]) {
                        knapsack[i][j] = knapsack[i - 1][j - minus[i]] + plus[i];
                    } else {
                        knapsack[i][j] = knapsack[i - 1][j];
                    }
                } else {
                    knapsack[i][j] = knapsack[i - 1][j];
                }
            }
        }

        System.out.println(knapsack[N][hp - 1]);
    }

}
