// 백준 2304 - 창고 다각형

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_2304 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int max = 0;
        int N = Integer.parseInt(br.readLine());
        int[][] data = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
            if (max < data[i][1]) max = data[i][1];
        }

        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int firstIdx = -1;
        int lastIdx = -1;
        for (int i = 0; i < N; i++) {
            if (data[i][1] == max) {
                firstIdx = i;
                break;
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            if (data[i][1] == max) {
                lastIdx = i;
                break;
            }
        }

        int[] sum = new int[1001];

        for (int i = data[firstIdx][0]; i <= data[lastIdx][0]; i++) {
            sum[i] = max;
        }

        for (int i = 0; i < N; i++) {
            if (data[i][1] == max) break;
            for (int j = data[i][0]; ; j++) {
                if (sum[j] < data[i][1]) sum[j] = data[i][1];
                else break;
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            if (data[i][1] == max) break;
            for (int j = data[i][0]; ; j--) {
                if (sum[j] < data[i][1]) sum[j] = data[i][1];
                else break;
            }
        }

        int answer = 0;
        for (int i = 0; i <= 1000; i++) {
            answer += sum[i];
        }

        System.out.println(answer);
    }

}

