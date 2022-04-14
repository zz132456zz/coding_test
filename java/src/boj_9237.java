// 백준 9237 - 이장님 초대

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_9237 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(data);

        int max = Integer.MIN_VALUE;
        int time = 1;
        for (int i = N - 1; i >= 0; i--) {
            if (max < time + data[i]) {
                max = time + data[i];
            }
            time++;
        }

        System.out.println(max + 1);
    }

}
