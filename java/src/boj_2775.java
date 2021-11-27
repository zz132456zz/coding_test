// 백준 2775 - 부녀회장이 될테야

import java.io.*;

public class boj_2775 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        int[][] apart = new int[15][15];
        for (int i = 0; i < 15; i++) {
            apart[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                apart[i][j] = apart[i][j - 1] + apart[i - 1][j];
            }
        }
        
        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            bw.write(apart[k][n] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
