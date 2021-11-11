// 백준 23322 - 초콜릿 뺏어 먹기

import java.util.Arrays;
import java.util.Scanner;

public class boj_23322 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = scanner.nextInt();
        }

        int min = data[0];
        int answer = 0;
        int day = 0;

        while (min != data[N - 1]) {
            answer += data[N - 1] - min;
            data[N - 1] = min;
            day += 1;
            Arrays.sort(data);
        }

        System.out.println(answer + " " + day);
    }

}
