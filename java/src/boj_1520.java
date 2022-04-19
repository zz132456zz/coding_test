// 백준 1520 - 내리막 길

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1520 {

    static int M, N;  // 산의 세로, 가로 크기
    static int[][] map;  // 각 지점의 높이 정보
    static int[][] count;
    static int answer;  // 정답
    static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};  // 4방향 탐색

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());  // 산의 세로 크기
        N = Integer.parseInt(st.nextToken());  // 산의 가로 크기
        map = new int[M][N];  // 각 지점의 높이
        count = new int[M][N];
        for (int i = 0; i < M; i++) {  // 각 지점의 높이 입력받기
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                count[i][j] = -1;
            }
        }


        answer = move(0, 0);  // 0, 0에서 탐색시작

        System.out.println(answer);
    }

    // 내리막길을 따라 탐색한다.
    public static int move(int r, int c) {
        if (r == M - 1 && c == N - 1) {  // 목적지에 도착했으면 정답 카운트 하나 늘리고 return
            return 1;
        }

        if (count[r][c] != -1) {
            return count[r][c];
        }

        count[r][c] = 0;
        for (int i = 0; i < 4; i++) {  // 4방 탐색
            int nr = r + delta[i][0];
            int nc = c + delta[i][1];
            if (0 <= nr && nr < M && 0 <= nc && nc < N && map[r][c] > map[nr][nc]) {
                count[r][c] += move(nr, nc);
            }
        }

        return count[r][c];
    }
}
