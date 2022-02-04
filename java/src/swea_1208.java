// SWEA 1208 - [S/W 문제해결 기본] 1일차 - Flatten

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1208 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int tc = 1; tc <= 10; tc++) {
            int dumpNum = Integer.parseInt(br.readLine());
            int[] data = new int[100];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(data);
            for (int i = 0; i < dumpNum; i++) {
                data[0]++;
                data[99]--;
                Arrays.sort(data);
            }

            bw.write("#" + tc + " " + (data[99] - data[0]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
