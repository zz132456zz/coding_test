// 백준 9656 - 돌 게임 2

import java.io.*;

public class boj_9656 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        if (N % 2 == 0) {
            bw.write("SK\n");
        } else {
            bw.write("CY\n");
        }

        bw.flush();
        bw.close();
    }

}