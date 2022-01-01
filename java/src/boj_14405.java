// 백준 14405 - 피카츄

import java.io.*;

public class boj_14405 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();

        S = S.replaceAll("pi", " ").replaceAll("ka", " ").replaceAll("chu", " ");
        S = S.replaceAll(" ", "");

        if (S.length() == 0) {
            bw.write("YES\n");
        } else {
            bw.write("NO\n");
        }
        bw.flush();
        bw.close();
    }

}
