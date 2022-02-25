// 백준 17144 - 미세먼지 안녕!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17144 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int answer = 0;
        int[] airCleaner = new int[2];

        int[][] data = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                if (data[i][j] == -1) {
                    airCleaner[0] = i;
                    airCleaner[1] = j;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            int[][] temp = new int[R][C];
            spread(data, temp, R, C);  // 확산
            circulation(temp, data, airCleaner, R, C);  // 순환
            data = temp;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                answer += data[i][j];
            }
        }

        System.out.println(answer + 2);
    }

    public static void spread(int[][] data, int[][] temp, int R, int C) {
        int[][] delta = {{0 ,1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (data[i][j] > 0) {
                    int spreadNum = data[i][j] / 5;  // 확산되는수
                    int cnt = 0;  // 몇번 확산했는지 카운트
                    for (int k = 0; k < 4; k++) {
                        int x = i + delta[k][0];
                        int y = j + delta[k][1];
                        if (0 <= x && x < R && 0 <= y && y < C && data[x][y] != -1) {  // 확산 가능하면
                            temp[x][y] += spreadNum;  // 확산해주기
                            cnt++;  // cnt 추가
                        }
                    }
                    temp[i][j] += data[i][j] - spreadNum * cnt;  // 확산하고 남은거
                    data[i][j] = 0;
                }
            }
        }
    }

    public static void circulation(int[][] temp, int[][] data, int[] airCleaner, int R, int C) {
        int topR = airCleaner[0] - 1;
        int topC = airCleaner[1];
        int bottomR = airCleaner[0];
        int bottomC = airCleaner[1];

        // 확산되는 방향 역방향으로 덮어쓰기
        int[][] topDelta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[][] bottomDelta = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int i = 0; i < 4; i++) {
            while (true) {  // 공기청정기 위쪽
                int x = topR + topDelta[i][0];
                int y = topC + topDelta[i][1];
                if (0 <= x && x <= airCleaner[0] - 1 && 0 <= y && y < C) {
                    temp[topR][topC] = temp[x][y];
                    topR = x;
                    topC = y;
                } else {
                    break;
                }
            }

            while (true) {  // 공기청정기 아래쪽
                int x = bottomR + bottomDelta[i][0];
                int y = bottomC + bottomDelta[i][1];
                if (airCleaner[0] <= x && x < R && 0 <= y && y < C) {
                    temp[bottomR][bottomC] = temp[x][y];
                    bottomR = x;
                    bottomC = y;
                } else {
                    break;
                }
            }
        }

        // 공기청정기 바람 나오는 쪽은 무조건 0
        temp[airCleaner[0] -1][airCleaner[1] + 1] = 0;
        temp[airCleaner[0]][airCleaner[1] + 1] = 0;
        // 공기청정기 위치 -1로
        temp[airCleaner[0] -1][airCleaner[1]] = -1;
        temp[airCleaner[0]][airCleaner[1]] = -1;
    }

}
