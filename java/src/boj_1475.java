// 백준 1475 - 방 번호

import java.io.*;

public class boj_1475 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String N = br.readLine();

        int[] data = new int[10];
        for (int i = 0; i < N.length(); i++) {
            data[Integer.parseInt(Character.toString(N.charAt(i)))]++;
        }

        data[6] = (data[6] + data[9] + 1) / 2;

        int max = 0;
        for (int i = 0; i < 9; i++) {
            max = Math.max(max, data[i]);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }

}
