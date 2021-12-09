// 백준 1002 - 터렛

import java.io.*;
import java.util.StringTokenizer;

public class boj_1002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            if (x1 == x2 && y1 == y2) {
                if (r1 == r2) {
                    bw.write("-1\n");
                } else {
                    bw.write("0\n");
                }
            } else {
                double len = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
                double sum = r1 + r2;
                if (len == sum) {
                    bw.write("1\n");
                } else if (len > sum) {
                    bw.write("0\n");
                } else if (r1 + len == r2) {
                    bw.write("1\n");
                } else if (r2 + len == r1) {
                    bw.write("1\n");
                } else if (r1 + len < r2) {
                    bw.write("0\n");
                } else if (r2 + len < r1) {
                    bw.write("0\n");
                } else {
                    bw.write("2\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }

}
