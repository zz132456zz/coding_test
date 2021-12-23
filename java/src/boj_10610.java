// 백준 11610 - 30

import java.io.*;
import java.util.Arrays;

public class boj_10610 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String N = br.readLine();
        long[] data = new long[N.length()];
        long sum = 0;
        for (int i = 0; i < N.length(); i++) {
            long temp = Long.parseLong(Character.toString(N.charAt(i)));
            data[i] = temp;
            sum += temp;
        }

        Arrays.sort(data);

        if (data[0] == 0 && sum % 3 == 0) {
            for (int i = N.length() - 1; i >= 0; i--) {
                bw.write(data[i] + "");
            }
            bw.write("\n");
        } else {
            bw.write("-1\n");
        }

        bw.flush();
        bw.close();
    }

}
