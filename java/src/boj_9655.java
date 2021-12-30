// 백준 9655 - 돌 게임

import java.io.*;

public class boj_9655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        if (N % 2 == 0) {
            bw.write("CY\n");
        } else {
            bw.write("SK\n");
        }

        bw.flush();
        bw.close();
    }

}
