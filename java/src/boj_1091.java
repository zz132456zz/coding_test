// 백준 1091 - 카드 섞기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1091 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        int[] S = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int[] mix = new int[N];
        for (int i = 0; i < N; i++) {
            mix[i] = i % 3;
        }

        int[] first = Arrays.copyOf(mix, mix.length);

        int answer = 0;
        while (!Arrays.equals(P, mix)) {
            int[] temp = new int[N];

            for (int i = 0; i < N; i++) {
                temp[i] = mix[S[i]];
            }

            if (Arrays.equals(temp, first)){
                answer = -1;
                break;
            }

            mix = temp;
            answer++;
        }

        System.out.println(answer);
    }

}
