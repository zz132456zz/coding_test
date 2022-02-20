// 백준 2562 - 최댓값

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2562 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxNum = 0;
        int maxIdx = 0;

        for (int i = 1; i <= 9; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (maxNum < temp) {
                maxNum = temp;
                maxIdx = i;
            }
        }

        System.out.println(maxNum);
        System.out.println(maxIdx);
    }

}
