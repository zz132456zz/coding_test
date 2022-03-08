// 백준 11656 - 접미사 배열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_11656 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();
        String[] strArr = new String[S.length()];
        for (int i = 0; i < S.length(); i++) {
            strArr[i] = S.substring(i);
        }

        Arrays.sort(strArr);

        for (int i = 0; i < S.length(); i++) {
            sb.append(strArr[i]).append("\n");
        }

        System.out.print(sb);
    }

}
