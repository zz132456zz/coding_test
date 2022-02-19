// 백준 2475 - 검증수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2475 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int temp = Integer.parseInt(st.nextToken());
            sum += (int) Math.pow(temp, 2);
        }

        System.out.println(sum % 10);
    }

}
