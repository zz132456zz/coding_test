// 백준 15663 - N과 M (9)

import java.util.*;

public class boj_15663 {

    private static int N;
    private static int M;
    private static int[] data;
    private static LinkedHashSet<String> strlist = new LinkedHashSet<>();

    private static void dfs(List<Integer> arr, boolean[] visited, int depth) {
        if (depth == M) {
            String str = arr.toString().replaceAll("[\\[\\]]","").replaceAll("[,]","");
            strlist.add(str);
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr.add(data[i]);
                dfs(arr, visited, depth + 1);
                visited[i] = false;
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
        boolean[] visited = new boolean[N];
        dfs(arr, visited, 0);

        for (String str : strlist) {
            System.out.println(str);
        }
    }

}
