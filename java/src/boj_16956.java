// 백준 16956 - 늑대와 양

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16956 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] data = new char[R][C];
        for (int i = 0; i < R; i++) {
            data[i] = br.readLine().toCharArray();
        }

        int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        out : for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (data[i][j] == 'W') {
                    for (int d = 0; d < 4; d++) {
                        int nr = i + delta[d][0];
                        int nc = j + delta[d][1];
                        if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                            if (data[nr][nc] == '.') {
                                data[nr][nc] = 'D';
                            } else if (data[nr][nc] == 'S') {
                                answer.append(0);
                                break out;
                            }
                        }
                    }
                }
            }
        }

        if (answer.length() == 0) {
            answer.append(1).append("\n");
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    answer.append(data[i][j]);
                }
                answer.append("\n");
            }
            System.out.print(answer);
        } else {
            System.out.println(answer);
        }
    }

}
