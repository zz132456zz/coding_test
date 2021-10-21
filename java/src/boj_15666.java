// 백준 15666 - N과 M (12)

import java.util.*;

public class boj_15666 {

    private static int N;
    private static int M;
    private static int[] data;
    private static LinkedHashSet<String> strlist = new LinkedHashSet<>();

    public static void dfs(int now, List<Integer> arr, int depth) {
        if (depth == M) {
            String str = arr.toString().replaceAll("[\\[\\]]","").replaceAll("[,]","");
            strlist.add(str);
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

        for (String str : strlist) {
            System.out.println(str);
        }
    }

}
