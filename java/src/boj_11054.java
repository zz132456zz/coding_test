// 백준 11054 - 가장 긴 바이토닉 부분 수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11054 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        int[] inc = new int[N];
        int[] dec = new int[N];


        for (int i = 0; i < N; i++) {
            inc[i] = 1;
            for (int j = 0; j < i; j++) {
                if (data[i] > data[j]) {
                    inc[i] = Math.max(inc[i], inc[j] + 1);
                }
            }
        }

        for (int i = N - 1; i >= 0 ; i--) {
            dec[i] = 1;
            for (int j = N - 1; j > i ; j--) {
                if (data[i] > data[j]) {
                    dec[i] = Math.max(dec[i], dec[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, inc[i] + dec[i]);
        }

        System.out.println(max - 1);
    }

}
