// 백준 1251 - 단어 나누기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boj_1251 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = null;
        StringBuilder answer = null;
        String word = br.readLine();
        int len = word.length();

        List<String> list = new ArrayList<>();

        for (int i = 1; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                answer = new StringBuilder();
                sb = new StringBuilder(word.substring(0, i));
                answer.append(sb.reverse());
                sb = new StringBuilder(word.substring(i, j));
                answer.append(sb.reverse());
                sb = new StringBuilder(word.substring(j));
                answer.append(sb.reverse());
                list.add(answer.toString());
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0));
    }

}
