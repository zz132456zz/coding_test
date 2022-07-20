// 백준 12904 - A와 B

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_12904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder S = new StringBuilder(br.readLine());
        StringBuilder T = new StringBuilder(br.readLine());

        while (S.length() != T.length()) {
            if (T.charAt(T.length() - 1) == 'A') {
                T.setLength(T.length() - 1);
            } else {
                T.setLength(T.length() - 1);
                T.reverse();
            }
        }

        if (S.toString().equals(T.toString())) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

}
