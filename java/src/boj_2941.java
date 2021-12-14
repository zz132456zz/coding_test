// 백준 2941 - 크로아티아 알파벳

import java.io.*;

public class boj_2941 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String data = br.readLine();
        String[] alphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        int answer = 0;

        for (int i = 0; i < 8; i++) {
            while (data.contains(alphabet[i])) {
                data = data.replaceFirst(alphabet[i], " ");
                answer++;
            }
        }

        data = data.replaceAll(" ", "");

        bw.write(answer + data.length() + "\n");
        bw.flush();
        bw.close();
    }

}
