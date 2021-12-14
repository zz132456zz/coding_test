// 백준 1316 - 그룹 단어 체커

import java.io.*;

public class boj_1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int answer = N;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            while (!word.isEmpty()) {
                char alpha = word.charAt(0);
                word = word.substring(1);
                if (!(word.indexOf(alpha) == -1 || word.indexOf(alpha) == 0)) {
                    answer--;
                    break;
                }
            }

        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

}
