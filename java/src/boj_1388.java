// 백준 1388 - 바닥 장식

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1388 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) continue;

                if (map[i][j] == '|') {
                    for (int k = i; k < N; k++) {
                        if (map[k][j] == '|') {
                            visited[k][j] = true;
                        } else {
                            break;
                        }
                    }
                    answer++;
                } else if (map[i][j] == '-') {
                    for (int k = j; k < M; k++) {
                        if (map[i][k] == '-') {
                            visited[i][k] =true;
                        } else {
                            break;
                        }
                    }
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

}
