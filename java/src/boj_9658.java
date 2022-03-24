// 백준 9658 - 돌 게임 4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9658 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println("CY");
            return;
        } else if (N == 2) {
            System.out.println("SK");
            return;
        } else if (N == 3) {
            System.out.println("CY");
            return;
        } else if (N == 4) {
            System.out.println("SK");
            return;
        }

        int[] data = new int[N + 1];
        data[1] = 0;
        data[2] = 1;
        data[3] = 0;
        data[4] = 1;
        for (int i = 5; i <= N; i++) {
            if (data[i - 1] == 1 && data[i - 3] == 1 && data[i - 4] == 1) {
                data[i] = 0;
            } else {
                data[i] = 1;
            }
        }

        if (data[N] == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }

    }

}
