// 백준 9251 - LCS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9251 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] chars1 = (' ' + br.readLine()).toCharArray();
        char[] chars2 = (' ' + br.readLine()).toCharArray();

        int[][] lcs = new int[chars1.length][chars2.length];

        for (int i = 1; i < chars1.length; i++) {
            for (int j = 1; j < chars2.length; j++) {
                if (chars1[i] == chars2[j]) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                max = Math.max(max, lcs[i][j]);
            }
        }

        System.out.println(max);
    }

}
