// 백준 1058 - 친구

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_1058 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                if (map[i][j] == 'Y') {
                    cnt++;
                } else {
                    for (int k = 0; k < N; k++) {
                        if (k == i || k == j) continue;
                        if (map[i][k] == 'Y' && map[j][k] == 'Y') {
                            cnt++;
                            break;
                        }
                    }
                }
            }
            if (max < cnt) max = cnt;
        }

        System.out.println(max);
    }

}
