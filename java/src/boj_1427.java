// 백준 1427 - 소트인사이드

import java.io.*;
import java.util.Arrays;

public class boj_1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String N = br.readLine();

        char[] data = N.toCharArray();
        Arrays.sort(data);

        String answer = "";
        for (int i = data.length - 1; i >= 0; i--) {
            answer += data[i];
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

}
