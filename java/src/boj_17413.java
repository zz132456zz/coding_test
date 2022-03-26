// 백준 17413 - 단어 뒤집기 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();

        boolean isTag = false;
        int idx = 0;

        StringBuilder answer = new StringBuilder();

        while (true) {
            if (idx == S.length()) break;

            if (isTag) {
                if (S.charAt(idx) == '>'){
                    answer.append('<').append(sb).append('>');
                    sb.setLength(0);
                    isTag = false;
                } else {
                    sb.append(S.charAt(idx));
                }
                idx++;
                continue;
            }

            if (S.charAt(idx) == '<' || S.charAt(idx) == ' ') {
                if (S.charAt(idx) == '<') {
                    answer.append(sb.reverse());
                    sb.setLength(0);
                    isTag = true;
                } else {
                    answer.append(sb.reverse()).append(" ");
                    sb.setLength(0);
                }
            } else {
                sb.append(S.charAt(idx));
            }
            idx++;
        }
        answer.append(sb.reverse());

        System.out.println(answer);
    }

}
