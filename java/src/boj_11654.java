// 백준 11654 - 아스키 코드

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char c = br.readLine().charAt(0);

        System.out.println((int) c);
    }

}
