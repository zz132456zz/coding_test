// 백준 1759 - 암호 만들기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1759 {

    static StringBuilder sb;
    static int L;
    static int C;
    static char[] data;
    static char[] chars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        data = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            data[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(data);

        chars = new char[L];
        combination(0, 0);

        System.out.print(sb.toString());
    }

    public static void combination(int cnt, int start) {
        if (cnt == L) {
            int consonant = 0;  // 자음
            int vowel = 0;  // 모음
            for (char c : chars) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowel++;
                }
            }
            consonant = chars.length - vowel;
            if (consonant >= 2 && vowel >= 1) {
                for (char c : chars) {
                    sb.append(c);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            chars[cnt] = data[i];
            combination(cnt + 1, i + 1);
        }
    }

}
