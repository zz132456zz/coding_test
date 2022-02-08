// SWEA 9229 - 한빈이와 Spot Mart

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class swea_9229 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Integer[] data = new Integer[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }

            int answer = -1;

            Arrays.sort(data, Collections.reverseOrder());

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (data[i] + data[j] <= M) {
                        answer = Math.max(answer, data[i] + data[j]);
                        break;
                    }
                }
            }

            bw.write("#" + tc + " " + answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
