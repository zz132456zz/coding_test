// 백준 1543 - 문서 검색

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1543 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        String word = br.readLine();

        int answer = 0;
        int index = 0;

        while ((index = sb.lastIndexOf(word)) != -1) {
            sb.setLength(index);
            answer++;
        }

        System.out.println(answer);
    }

}
