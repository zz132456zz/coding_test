// 백준 11004 - K번째 수

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11004 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] data = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(data);

        bw.write(data[K - 1] + "\n");
        bw.flush();
        bw.close();
    }

}
