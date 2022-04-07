// 백준 14502 - 연구소

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14502 {

    static int N, M;
    static int[][] map;
    static ArrayList<int[]> zeroList;
    static int zeroCnt;
    static ArrayList<int[]> virusList;
    static int[] choose;
    static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        zeroList = new ArrayList<>();
        virusList = new ArrayList<>();
        choose = new int[3];
        max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    zeroList.add(new int[] {i, j});
                } else if (map[i][j] == 2) {
                    virusList.add(new int[] {i, j});
                }
            }
        }

        zeroCnt = zeroList.size();

        combination(0, 0);

        System.out.println(max);
    }

    public static void combination(int start, int cnt) {
        if (cnt == 3) {
            virusBFS();
            return;
        }

        for (int i = start; i < zeroCnt; i++) {
            choose[cnt] = i;
            combination(i + 1, cnt + 1);
        }
    }

    public static void virusBFS() {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < 3; i++) {
            temp[zeroList.get(choose[i])[0]][zeroList.get(choose[i])[1]] = 1;
        }

        int nZeroCnt = zeroCnt - 3;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < virusList.size(); i++) {
            queue.add(virusList.get(i));
        }

        while (!queue.isEmpty()) {
            if (nZeroCnt < max) break;

            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + delta[i][0];
                int nc = cur[1] + delta[i][1];
                if (0 <= nr && nr < N && 0 <= nc && nc < M && temp[nr][nc] == 0) {
                    temp[nr][nc] = 2;
                    queue.add(new int[] {nr, nc});
                    nZeroCnt--;
                }
            }
        }

        if (nZeroCnt > max) max = nZeroCnt;
    }

}
