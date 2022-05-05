// 백준 16198 - 에너지 모으기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_16198 {

    static List<Integer> data;

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        data = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data.add(Integer.parseInt(st.nextToken()));
        }

        dfs(N, 0);

        System.out.println(max);
    }

    public static void dfs(int remain, int sum) {
        if (remain == 2) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 1; i < remain - 1; i++) {
            int temp = data.get(i);
            int energy = data.get(i - 1) * data.get(i + 1);
            data.remove(i);
            dfs(remain - 1, sum + energy);
            data.add(i, temp);
        }
    }

}
