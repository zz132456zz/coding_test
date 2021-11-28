// 백준 1157 - 단어 공부

import java.io.*;

public class boj_1157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String data = br.readLine().toUpperCase();

        int[] cnt = new int[26];
        for (int i = 0; i < data.length(); i++) {
            cnt[data.charAt(i) - 'A']++;
        }

        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, cnt[i]);
        }

        char temp = 'a';
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == max) {
                if (temp != 'a') {
                    temp = '?';
                    break;
                }
                temp = (char) ('A' + i);
            }
        }

        bw.write(temp);
        bw.flush();
        bw.close();
    }
}
