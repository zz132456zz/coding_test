// SWEA 6808 - 규영이와 인영이의 카드게임

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_6808 {

    static List<Integer> data;
    static int[] nums;
    static int[] result;

    static int win;
    static int lose;

    public static void permutation(int cnt, boolean[] visited) {
        if (cnt == 9) {
            int sumScore1 = 0;
            int sumScore2 = 0;

            for (int i = 0; i < 9; i++) {
                if (data.get(i) < result[i]) {
                    sumScore2 += data.get(i) + result[i];
                } else {
                    sumScore1 += data.get(i) + result[i];
                }
            }

            if (sumScore1 < sumScore2) {
                lose++;
            } else if (sumScore1 > sumScore2) {
                win++;
            }

            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[cnt] = nums[i];
                permutation(cnt + 1, visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            data = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                data.add(Integer.parseInt(st.nextToken()));
            }

            nums = new int[9];
            for (int i = 1, idx = 0; i <= 18; i++) {
                if (data.indexOf(i) < 0) {
                    nums[idx++] = i;
                }
            }

            win = 0;
            lose = 0;
            result = new int[9];
            boolean[] visited = new boolean[9];
            permutation(0, visited);

            sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
        }

        System.out.println(sb.toString());
    }

}
