// 백준 11444 - 피보나치 수 6

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class boj_11444 {

    static long n;
    static Map<Long, long[][]> memoMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Long.parseLong(br.readLine());

        memoMap = new HashMap<>();

        long[][] map = {{1, 1}, {1, 0}};

        long[][] result = partition(map, n);

        System.out.println(result[1][0]);
    }

    public static long[][] partition(long[][] map, long B) {
        if (B == 1) {
            return map;
        } else if (B % 2 == 0) {
            long[][] temp = memoMap.get(B / 2);
            if (temp == null) {
                temp = partition(map, B / 2);
                memoMap.put(B / 2, temp);
            }
            return mul(temp, temp);
        } else {
            long[][] temp1 = memoMap.get(B / 2);
            long[][] temp2 = memoMap.get(B / 2 + 1);
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

    public static long[][] mul(long[][] a, long[][] b) {
        long[][] temp = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                long sum = 0;
                for (int k = 0; k < 2; k++) {
                    sum += a[i][k] * b[k][j];
                }
                temp[i][j] = sum % 1000000007;
            }
        }
        return temp;
    }

}
