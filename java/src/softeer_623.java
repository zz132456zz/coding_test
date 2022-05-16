// 소프티어 623 - [21년 재직자 대회 예선] 비밀메뉴

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class softeer_623 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < M; i++) {
            key.append(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        StringBuilder user = new StringBuilder();
        for (int i = 0; i < N; i++) {
            user.append(st.nextToken());
        }

        if (user.toString().contains(key.toString())) {
            System.out.println("secret");
        } else {
            System.out.println("normal");
        }

    }

}
