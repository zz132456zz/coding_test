// 백준 10830 - 행렬 제곱

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_10830 {

    static int N;
    static Map<Long, int[][]> memoMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        memoMap = new HashMap<>();

        int[][] result = partition(map, B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j] % 1000).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static int[][] partition(int[][] map, long B) {
        if (B == 1) {
            return map;
        } else if (B % 2 == 0) {
            int[][] temp = memoMap.get(B / 2);
            if (temp == null) {
                temp = partition(map, B / 2);
                memoMap.put(B / 2, temp);
            }
            return mul(temp, temp);
        } else {
            int[][] temp1 = memoMap.get(B / 2);
            int[][] temp2 = memoMap.get(B / 2 + 1);
            if (temp1 == null) {
                temp1 = partition(map, B / 2);
                memoMap.put(B / 2, temp1);
            }
            if (temp2 == null) {
                temp2 = partition(map, B/ 2 + 1);
                memoMap.put(B / 2 + 1, temp2);
            }
            return mul(temp1, temp2);
        }
    }

    public static int[][] mul(int[][] a, int[][] b) {
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += a[i][k] * b[k][j];
                }
                temp[i][j] = sum % 1000;
            }
        }
        return temp;
    }

}
