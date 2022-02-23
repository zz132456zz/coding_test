// 백준 2567 - 색종이 - 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2567 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int[][] data = new int[100][100];
        int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int a = x; a < x + 10; a++) {
                for (int b = y; b < y + 10; b++) {
                    data[a][b] = 1;
                }
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (data[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int _x = i + delta[k][0];
                        int _y = j + delta[k][1];
                        if (0 <= _x && _x < 100 && 0 <= _y && _y < 100 && data[_x][_y] == 1) {
                            continue;
                        } else {
                            answer++;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }

}
