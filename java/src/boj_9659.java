// 백준 9659 - 돌 게임 5

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(br.readLine());

        if (N % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }

    }

}
