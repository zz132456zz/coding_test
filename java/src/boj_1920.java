// 백준 1920 - 수 찾기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] NArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            NArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(NArr);

        int M = Integer.parseInt(br.readLine());
        int[] MArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            MArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            if (Arrays.binarySearch(NArr, MArr[i]) >= 0) {
                answer.append(1).append("\n");
            } else {
                answer.append(0).append("\n");
            }
        }

        System.out.println(answer.toString());
    }

}
