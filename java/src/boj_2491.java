// 백준 2491 - 수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2491 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        int cntUp = 1;
        int cntDown = 1;
        int max = 1;

        for (int i = 0; i < N - 1; i++) {
            if (data[i] <= data[i + 1]) cntUp++;
            else {
                if (max < cntUp) max = cntUp;
                cntUp = 1;
            }

            if (data[i] >= data[i + 1]) cntDown++;
            else {
                if (max < cntDown) max = cntDown;
                cntDown = 1;
            }
        }
        if (max < cntUp) max = cntUp;
        if (max < cntDown) max = cntDown;
        System.out.println(max);
    }

}
