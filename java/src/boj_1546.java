// 백준 1546 - 평균

import java.io.*;
import java.util.StringTokenizer;

public class boj_1546 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] data = new double[N];
        double max = 0;
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            data[i] = temp;
            max = Math.max(max, temp);
        }

        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += data[i] / max * 100;
        }

        bw.write((sum / N) + "\n");
        bw.flush();
        bw.close();
    }

}
