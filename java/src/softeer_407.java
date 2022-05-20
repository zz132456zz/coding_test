// 소프티어 407 - 바이러스


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class softeer_407 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long K = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());

        for (int i = 0; i < N; i++) {
            K *= P;
            K %= 1000000007;
        }

        System.out.println(K);
    }

}
