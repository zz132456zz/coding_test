// 백준 15657 - N과 M (8)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class boj_15657 {

    private static int N;
    private static int M;
    private static int[] data;

    public static void dfs(int now, List<Integer> arr, int depth) {
        if (depth == M) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (now <= data[i]) {
                arr.add(data[i]);
                dfs(data[i], arr, depth + 1);
                arr.remove(arr.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = scanner.nextInt();
        }

        Arrays.sort(data);

        List<Integer> arr = new ArrayList<>();
        dfs(-1, arr, 0);
    }

}
