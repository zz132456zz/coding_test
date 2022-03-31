// 백준 17404 - RGB거리 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17404 {

    public static int[][] deepCopy(int[][] data) {
        int[][] temp = new int[data.length][data[0].length];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = data[i].clone();
        }

        return temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[][] data = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        final int MAX_NUM = 10000;

        int[][] data1 = deepCopy(data);
        data1[1][1] = MAX_NUM;
        data1[1][2] = MAX_NUM;
        int[][] data2 = deepCopy(data);
        data2[1][0] = MAX_NUM;
        data2[1][2] = MAX_NUM;
        int[][] data3 = deepCopy(data);
        data3[1][0] = MAX_NUM;
        data3[1][1] = MAX_NUM;

        for (int i = 2; i <= N; i++) {
            data1[i][0] += Math.min(data1[i - 1][1], data1[i - 1][2]);
            data1[i][1] += Math.min(data1[i - 1][0], data1[i - 1][2]);
            data1[i][2] += Math.min(data1[i - 1][0], data1[i - 1][1]);

            data2[i][0] += Math.min(data2[i - 1][1], data2[i - 1][2]);
            data2[i][1] += Math.min(data2[i - 1][0], data2[i - 1][2]);
            data2[i][2] += Math.min(data2[i - 1][0], data2[i - 1][1]);

            data3[i][0] += Math.min(data3[i - 1][1], data3[i - 1][2]);
            data3[i][1] += Math.min(data3[i - 1][0], data3[i - 1][2]);
            data3[i][2] += Math.min(data3[i - 1][0], data3[i - 1][1]);
        }

        int min1 = Math.min(data1[N][1], data1[N][2]);
        int min2 = Math.min(data2[N][0], data2[N][2]);
        int min3 = Math.min(data3[N][0], data3[N][1]);

        System.out.println(Math.min(min1, Math.min(min2, min3)));
    }

}
