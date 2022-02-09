// SWEA 1210 - Ladder1

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class swea_1210 {

    static int[][] data;
    static int[][] delta = {{0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            data = new int[100][100];
            int finish = -1;
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                    if (data[i][j] == 2) finish = j;
                }
            }

            bw.write("#" + tc + " " + findStart(finish) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int findStart(int finish) {
        for (int layer = 99; layer >= 0; layer--) {
            boolean isMoved = false;
            for (int i = 0; i < 2; i++) {
                if (isMoved) {
                    continue;
                }
                int y = finish + delta[i][1];
                if (0 <= y && y < 100 && data[layer][y] == 1) {
                    while (0 <= y && y < 100 && data[layer][y] == 1) {
                        y += delta[i][1];
                    }
                    finish = y - delta[i][1];
                    isMoved = true;
                }

            }
        }
        return finish;
    }

}
