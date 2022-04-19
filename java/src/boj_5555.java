// 백준 5555 - 반지

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_5555 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        String findString = br.readLine();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String curString = br.readLine();
            curString += curString;
            if (curString.indexOf(findString) >= 0) {
                answer++;
            }
        }

        System.out.println(answer);
    }

}
