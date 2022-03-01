// 백준 2742 - 기찍 N

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2742 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = N; i > 0; i--) {
            sb.append(i).append("\n");
        }

        System.out.print(sb.toString());
    }

}
