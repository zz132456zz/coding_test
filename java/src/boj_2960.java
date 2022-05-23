// 백준 2960 - 에라토스테네스의 체

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2960 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;

        boolean[] array = new boolean[N + 1];
        Arrays.fill(array, true);

        int cnt = 0;

        fin : for (int i = 2; i <= N; i++) {
            if (array[i]) {
                int j = 1;
                while (i * j <= N) {
                    if (array[i * j]) {
                        cnt++;
                    }
                    array[i * j] = false;
                    j++;
                    if (cnt == K) {
                        answer = i * (j-1);
                        break fin;
                    }
                }
            }
        }

        System.out.println(answer);
    }

}
