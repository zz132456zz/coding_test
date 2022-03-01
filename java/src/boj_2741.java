// 백준 2741 - N 찍기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2741 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            sb.append(i).append("\n");
        }

        System.out.print(sb.toString());
    }

}
