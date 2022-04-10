// 백준 12865 - 평범한 배낭

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] data = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] knapsack = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            int W = data[i - 1][0];  // Weight
            int V = data[i - 1][1];  // Value
            for (int j = 1; j <= K; j++) {
                if (W <= j) {
                    if (knapsack[i - 1][j - W] + V > knapsack[i - 1][j]) {
                        knapsack[i][j] = knapsack[i - 1][j - W] + V;
                    } else {
                        knapsack[i][j] = knapsack[i - 1][j];
                    }
                } else {
                    knapsack[i][j] = knapsack[i - 1][j];
                }
            }
        }

        System.out.println(knapsack[N][K]);
    }

}
