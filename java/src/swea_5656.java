import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5656 {
    static int N, W, H;
    static int min;
    static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            int[][] map = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            min = Integer.MAX_VALUE;

            dfs(0, map);

            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int depth, int[][] next) {
        if (depth == N) {
            int brickCnt = countBrick(next);
            if (min > brickCnt) {
                min = brickCnt;
            }
            return;
        }

        for (int i = 0; i < W; i++) {
            int[][] now = deepCopy(next);
            dfs(depth + 1, drop(now, i));
        }

    }

    static int[][] drop(int[][] map, int c) {  // 공을 떨어트린 결과를 반환
        int[][] temp = deepCopy(map);

        for (int i = 0; i < H; i++) {
            if (temp[i][c] != 0) {
                breakBrick(temp, i, c, temp[i][c]);
                break;
            }
        }

        sortMap(temp);

        return temp;
    }

    static void breakBrick(int[][] map, int r, int c, int n) {
        map[r][c] = 0;
        for (int d = 0; d < 4; d++) {
            for (int i = 1; i < n; i++) {
                int nr = r + delta[d][0] * i;
                int nc = c + delta[d][1] * i;
                if (0 <= nr && nr < H && 0 <= nc && nc < W) {
                    if (map[nr][nc] != 0) {
                        breakBrick(map, nr, nc, map[nr][nc]);
                    }
                }
            }
        }
    }

    static void sortMap(int[][] map) {
        for (int i = 0; i < W; i++) {
            int idx = H - 1;
            for (int j = H - 1; j >= 0; j--) {
                if (map[j][i] != 0) {
                    if (idx != j) {
                        map[idx][i] = map[j][i];
                        map[j][i] = 0;
                    }
                    idx--;
                }
            }
        }
    }

    static int countBrick(int[][] map) {  // 남은 벽돌의 개수를 센다
        int brickCnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] != 0) brickCnt++;
            }
        }
        return brickCnt;
    }

    static int[][] deepCopy(int[][] map) {  // 2차원 배열 깊은 복사
        int[][] temp = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                temp[i][j] = map[i][j];
            }
        }
        return temp;
    }

}
