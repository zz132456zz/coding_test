// SWEA 15173 - Shuffle-O-Matic

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class swea_15173 {

    static int N;
    static int[] data;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            data = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }
            min = Integer.MAX_VALUE;

            dfs(0, data.clone());

            if (min == Integer.MAX_VALUE) min = -1;

            answer.append("#").append(t).append(" ").append(min).append("\n");
        }

        System.out.print(answer);
    }

    public static void dfs(int d, int[] cards) {
        if (d > 5) {
            return;
        }

        if (isSort(cards)) {
            min = Math.min(min, d);
            return;
        }

        int[] left = new int[N / 2];
        int[] right = new int[N / 2];
        for (int i = 0; i < N / 2; i++) {
            left[i] = cards[i];
        }
        for (int i = 0; i < N / 2; i++) {
            right[i] = cards[i + N / 2];
        }

        for (int i = 0; i < N; i++) {
            int[] next = shuffle(left, right, i);
            dfs(d + 1, next);
        }
    }

    public static boolean isSort(int[] cards) {
        for (int i = 0; i < cards.length - 1; i++) {
            if (Math.abs(cards[i] - cards[i + 1]) != 1) return false;
        }
        return true;
    }

    public static int[] shuffle(int[] left, int[] right, int x) {
        int[] result = new int[N];
        int leftIdx = x;
        int rightIdx = N / 2;
        for (int i = 0; i < N; i++) {
            if (leftIdx - x >= N / 2) {
                result[i] = right[rightIdx - N / 2];
                rightIdx++;
                continue;
            }

            if (rightIdx - N / 2 >= N / 2) {
                result[i] = left[leftIdx - x];
                leftIdx++;
                continue;
            }

            if (rightIdx <= leftIdx) {
                result[i] = right[rightIdx - N / 2];
                rightIdx++;
            } else {
                result[i] = left[leftIdx - x];
                leftIdx++;
            }
        }

        return result;
    }

}
