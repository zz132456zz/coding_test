// 백준 15683 - 감시

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_15683 {

    static class CCTV {
        int type;
        int row;
        int column;
        int direction;

        public CCTV(int type, int row, int column) {
            super();
            this.type = type;
            this.row = row;
            this.column = column;
        }

        public void setDirection(int direction) {
            this.direction = direction;
        }

        @Override
        public String toString() {
            return "CCTV [type=" + type + ", row=" + row + ", column=" + column + ", direction=" + direction + "]";
        }

    }

    static List<CCTV> list;

    static int cctvSize;

    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] data = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (1 <= data[i][j] && data[i][j] <= 5) {
                    list.add(new CCTV(data[i][j], i, j));
                }
            }
        }
        cctvSize = list.size();

        CCTV[] cctvList = new CCTV[cctvSize];
        min = Integer.MAX_VALUE;
        dfs(0, cctvList, data);

        System.out.println(min);
    }

    public static void dfs(int cnt, CCTV[] cctvList, int[][] data) {
        if (cnt == cctvSize) {
            int X = data.length;
            int Y = data[0].length;
            int[][] temp = copy(data);
            int sum = 0;

            for (int i = 0; i < cctvSize; i++) {
                observe(cctvList[i], temp);
            }

            for (int i = 0; i < X; i++) {
                for (int j = 0; j < Y; j++) {
                    if (temp[i][j] == 0) sum++;
                }
            }

            if (min > sum) min = sum;
            return;
        }

        cctvList[cnt] = list.get(cnt);

        cctvList[cnt].setDirection(1);
        dfs(cnt + 1, cctvList, data);
        cctvList[cnt].setDirection(2);
        dfs(cnt + 1, cctvList, data);
        cctvList[cnt].setDirection(3);
        dfs(cnt + 1, cctvList, data);
        cctvList[cnt].setDirection(4);
        dfs(cnt + 1, cctvList, data);
    }

    public static int[][] copy(int[][] data) {
        int X = data.length;
        int Y = data[0].length;
        int[][] temp = new int[X][Y];
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                temp[i][j] = data[i][j];
            }
        }
        return temp;
    }

    public static void observe(CCTV cctv, int[][] temp) {
        int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        switch (cctv.type) {
            case 1:
                if (cctv.direction == 1) {
                    check(delta[0], cctv, temp);
                } else if (cctv.direction == 2) {
                    check(delta[1], cctv, temp);
                } else if (cctv.direction == 3) {
                    check(delta[2], cctv, temp);
                } else if (cctv.direction == 4) {
                    check(delta[3], cctv, temp);
                }
                break;
            case 2:
                if (cctv.direction == 1 || cctv.direction == 3) {
                    check(delta[0], cctv, temp);
                    check(delta[2], cctv, temp);
                } else if (cctv.direction == 2 || cctv.direction == 4) {
                    check(delta[1], cctv, temp);
                    check(delta[3], cctv, temp);
                }
                break;
            case 3:
                if (cctv.direction == 1) {
                    check(delta[0], cctv, temp);
                    check(delta[1], cctv, temp);
                } else if (cctv.direction == 2) {
                    check(delta[1], cctv, temp);
                    check(delta[2], cctv, temp);
                } else if (cctv.direction == 3) {
                    check(delta[2], cctv, temp);
                    check(delta[3], cctv, temp);
                } else if (cctv.direction == 4) {
                    check(delta[3], cctv, temp);
                    check(delta[0], cctv, temp);
                }
                break;
            case 4:
                if (cctv.direction == 1) {
                    check(delta[0], cctv, temp);
                    check(delta[1], cctv, temp);
                    check(delta[2], cctv, temp);
                } else if (cctv.direction == 2) {
                    check(delta[1], cctv, temp);
                    check(delta[2], cctv, temp);
                    check(delta[3], cctv, temp);
                } else if (cctv.direction == 3) {
                    check(delta[2], cctv, temp);
                    check(delta[3], cctv, temp);
                    check(delta[0], cctv, temp);
                } else if (cctv.direction == 4) {
                    check(delta[3], cctv, temp);
                    check(delta[0], cctv, temp);
                    check(delta[1], cctv, temp);
                }
                break;
            case 5:
                check(delta[0], cctv, temp);
                check(delta[1], cctv, temp);
                check(delta[2], cctv, temp);
                check(delta[3], cctv, temp);
                break;
        }

    }

    public static void check(int[] delta, CCTV cctv, int[][] temp) {
        int X = temp.length;
        int Y = temp[0].length;
        int x = cctv.row;
        int y = cctv.column;
        while (true) {
            x += delta[0];
            y += delta[1];

            if (0 <= x && x < X && 0 <= y && y < Y) {
                if (temp[x][y] == 6) return;
                if (temp[x][y] == 0) temp[x][y] = 8;
            } else {
                return;
            }
        }
    }

}
