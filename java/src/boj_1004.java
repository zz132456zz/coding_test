// 백준 1004 - 어린 왕자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1004 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(br.readLine());
            int answer = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                boolean isIn1 = Math.pow(x1 - cx, 2) + Math.pow(y1 - cy, 2) < r * r;
                boolean isIn2 = Math.pow(x2 - cx, 2) + Math.pow(y2 - cy, 2) < r * r;

                if (isIn1 && !isIn2) answer++;
                else if (!isIn1 && isIn2) answer++;
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
