// 백준 2884 - 알람 시계

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2884 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        M = (M - 45) % 60;
        if (M < 0) {
            M += 60;
            H -= 1;
            if (H < 0) {
                H = 23;
            }
        }

        sb.append(H).append(" ").append(M);

        System.out.println(sb);
    }

}
