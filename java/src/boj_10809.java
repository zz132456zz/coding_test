// 백준 10809 - 알파벳 찾기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_10809 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();

        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);

        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            alphabet[c - 'a'] = i;
        }

        for (int i = 0; i < 26; i++) {
            sb.append(alphabet[i]).append(" ");
        }

        System.out.println(sb);
    }

}
