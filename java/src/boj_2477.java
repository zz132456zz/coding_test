// 백준 2477 - 참외밭

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2477 {

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int K = Integer.parseInt(br.readLine());
        int[] data = new int[6];
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            data[i] = b;
        }

        int idx = -1;
        int max = 0;
        for (int i = 0; i < 6; i++) {
            int temp = data[i % 6] * data[(i + 1) % 6];
            if (max < temp) {
                max = temp;
                idx = i;
            }
        }

        int answer = max - data[(idx + 3) % 6] * data[(idx + 4) % 6];
        answer *= K;

        System.out.println(answer);
    }

}
