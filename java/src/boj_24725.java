// 백준 24725 - 엠비티아이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_24725 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] data = new char[N][M];
        for (int i = 0; i < N; i++) {
            data[i] = br.readLine().toCharArray();
        }

        int answer = 0;

        char[][] mbti = {{'E', 'I'}, {'N', 'S'}, {'F', 'T'}, {'P', 'J'}};
        int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {1, -1}, {1, 1}, {-1, 0}, {-1, 1}, {-1, -1}};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 8; k++) {
                    int cnt = 0;
                    for (int l = 0; l < 4; l++) {
                        int nr = i + delta[k][0] * l;
                        int nc = j + delta[k][1] * l;
                        if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                            if (data[nr][nc] == mbti[l][0] || data[nr][nc] == mbti[l][1]) {
                                cnt++;
                            }
                        }
                    }
                    if (cnt == 4) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }

}
