// 백준 4963 - 섬의 개수

import java.io.*;
import java.util.StringTokenizer;

public class boj_4963 {
    static int w;
    static int h;
    static int[][] dxy = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    static boolean isRange(int i, int j) {
        return i < 0 || j < 0 || i >= h || j >= w ? false : true;
    }

    static void bfs(int i, int j, int[][] map) {
        map[i][j] = 0;
        for (int k = 0; k < 8; k++) {
            int x = i + dxy[k][0];
            int y = j + dxy[k][1];
            if (isRange(x, y) && map[x][y] == 1) {
                bfs(x, y, map);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            int[][] map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int island = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1) {
                        island++;
                        bfs(i, j, map);
                    }

                }
            }

            bw.write(island + "\n");
        }

        bw.flush();
        bw.close();
    }

}
