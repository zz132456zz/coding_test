// SWEA 1767 - 프로세서 연결하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_1767 {
    static int N;
    static int max;
    static int totalCnt;
    static int min;
    static int[][] map;
    static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static ArrayList<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());  // 셀의 크기
            map = new int[N][N];
            list = new ArrayList<>();  // 가장자리가 아닌 코어리스트
            max = 0;  // 최대 연결 코어수
            min = Integer.MAX_VALUE;  // 최소 전선길이의 합
            totalCnt = 0;  // 가장자리가 아닌 코어의 개수
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if ((i == 0 || i == N - 1 || j == 0 || j == N - 1) && map[i][j] == 1) continue; // 가장자리 코어는 continue

                    if(map[i][j] == 1) {
                        list.add(new int[] {i, j});
                        totalCnt++;
                    }
                }
            }

            go(0, 0);

            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }

        System.out.println(sb);
    }

    private static void go(int index, int cCnt) {  // 부분집합으로 코어 전선놓기 시도, cCnt : 전원과 연결된 코어수
        if (index == totalCnt) {
            int res = getLength();
            if (max < cCnt) {
                max = cCnt;
                min = res;
            } else if (max == cCnt) {  // 최대 연결 코어수가 같으면
                if (min > res) min = res;
            }

            return;
        }

        int[] core = list.get(index);
        int r = core[0];
        int c = core[1];
        // 전선을 4방향으로 놓아보기
        for (int d = 0; d < 4; d++) {
            if (isAvailable(r, c, d)) { // 현재 코어위치 r,c 위치에서 d방향으로 전선을 놓을 수 있다면
                setStatus(r, c, d, 2);  // 전선 놓기
                go(index + 1, cCnt + 1);
                setStatus(r, c, d, 0);  // 전선 지우기
            }
        }

        // 전선 놓지 않기
        go(index + 1, cCnt);
    }

    private static boolean isAvailable(int r, int c, int d) {  // r,c 위치에서 d 방향으로 전선을 놓을수있는지 체크
        int nr = r;
        int nc = c;
        while (true) {
            nr += delta[d][0];
            nc += delta[d][1];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) break;
            // 다른 코어나 전선을 만나면 false
            if (map[nr][nc] >= 1) return false;
        }
        return true;
    }

    private static void setStatus(int r, int c, int d, int s) {  // r,c 위치에서 d방향으로 전선을 놓거나 지우거나
        int nr = r;
        int nc = c;
        while (true) {
            nr += delta[d][0];
            nc += delta[d][1];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) break;
            map[nr][nc] = s;
        }
    }

    private static int getLength() {  // 놓아진 전선의 길이의 합 계산
        int lCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2) {
                    lCnt++;
                }
            }
        }
        return lCnt;
    }
}
