// 백준 11051 - 이항 계수 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class boj_11051 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        BigInteger answer = new BigInteger("1");

        for (int i = 1; i <= K; i++) {
            answer = answer.multiply(new BigInteger(Integer.toString(N)));
            N--;
        }

        for (int i = 1; i <= K; i++) {
            answer = answer.divide(new BigInteger(Integer.toString(i)));
        }

        System.out.println(answer.mod(new BigInteger("10007")));
    }

}
