// 백준 4948 - 베르트랑 공준

import java.io.*;
import java.util.Arrays;

public class boj_4948 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = 123456 * 2;
        boolean[] array = new boolean[num + 1];
        Arrays.fill(array, true);

        for (int i = 2; i <= (int)Math.sqrt(num); i++) {
            if (array[i]) {
                int j = 2;
                while (i * j <= num) {
                    array[i * j] = false;
                    j++;
                }
            }
        }

        int[] sum = new int[num + 1];
        for (int i = 2; i <= num; i++) {
            sum[i] = array[i] ? sum[i - 1] + 1 : sum[i - 1];
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            bw.write((sum[2 * n] - sum[n]) + "\n");
        }

        bw.flush();
        bw.close();
    }

}
