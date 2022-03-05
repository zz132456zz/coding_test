// 백준 2908 - 상수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2908 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder strA = new StringBuilder(st.nextToken());
        StringBuilder strB = new StringBuilder(st.nextToken());

        int A = Integer.parseInt(strA.reverse().toString());
        int B = Integer.parseInt(strB.reverse().toString());

        if (A < B) {
            System.out.println(B);
        } else {
            System.out.println(A);
        }
    }

}
