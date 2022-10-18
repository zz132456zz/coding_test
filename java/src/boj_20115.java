// 백준 20115 - 에너지 드링크

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20115 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        double[] data = new double[N];
        st = new StringTokenizer(br.readLine());
        double max = 0;
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
            if (max < data[i]) max = data[i];
        }

        double sum = 0;
        for (int i = 0; i < N; i++) {
            if (data[i] == max) {
                sum += data[i];
            } else {
                sum += data[i] / 2;
            }
        }

        if ((int) sum == sum) System.out.println((int) sum);
        else System.out.println(sum);
    }

}
