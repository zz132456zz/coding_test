// 백준 2527 - 직사각형

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2527 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int[][] data = new int[4][8];
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 8; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 4; i++) {
            sb.append(check(data[i])).append("\n");
        }

        System.out.print(sb);
    }

    public static char check(int[] data) {
        if ((data[2] == data[4] && data[3] == data[5]) || (data[0] == data[6] && data[1] == data[7]) || (data[2] == data[4] && data[1] == data[7]) || (data[0] == data[6] && data[3] == data[5])) {
            return 'c';
        }
        if (data[5] == data[3] || data[1] == data[7]) {
            if (data[0] <= data[4] && data[4] <= data[2]) return 'b';
            if (data[0] <= data[6] && data[6] <= data[2]) return 'b';
            if (data[4] <= data[0] && data[0] <= data[6]) return 'b';
            if (data[4] <= data[2] && data[2] <= data[6]) return 'b';
        }
        if (data[2] == data[4] || data[0] == data[6]) {
            if (data[1] <= data[5] && data[5] <= data[3]) return 'b';
            if (data[1] <= data[7] && data[7] <= data[3]) return 'b';
            if (data[5] <= data[1] && data[1] <= data[7]) return 'b';
            if (data[5] <= data[3] && data[3] <= data[7]) return 'b';
        }

        if (data[2] < data[4] || data[6] < data[0] || data[3] < data[5] || data[7] < data[1]) return 'd';

        return 'a';
    }

}
