// 백준 10158 - 개미

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

        int x = -1;
        if (((p + t) / w) % 2 == 0) {
            x = (p + t) % w;
        } else {
            x = w - (p + t) % w;
        }

        int y = -1;
        if (((q + t) / h) % 2 == 0) {
            y = (q + t) % h;
        } else {
            y = h - (q + t) % h;
        }

        sb.append(x).append(" ").append(y);
        System.out.println(sb.toString());
    }

}
