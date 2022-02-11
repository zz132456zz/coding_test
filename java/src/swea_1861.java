// SWEA 1861 - 정사각형 방

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1861 {
    static int N;
    static int[][] map;
    static Queue<int[]> queue;
    static int[][] delta = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxCnt = -1;
            int maxRoom = -1;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    queue = new LinkedList<>();
                    queue.offer(new int[] {i, j});
                    int cnt = 1;

                    while(!queue.isEmpty()) {
                        int[] current = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int dx = current[0] + delta[k][0];
                            int dy = current[1] + delta[k][1];
                            if (0 <= dx && dx < N && 0 <= dy && dy < N && map[dx][dy] == map[current[0]][current[1]] + 1) {
                                queue.offer(new int[] {dx, dy});
                                cnt++;
                            }
                        }
                    }

                    if (cnt > maxCnt) {
                        maxCnt = cnt;
                        maxRoom = map[i][j];
                    } else if (cnt == maxCnt && map[i][j] < maxRoom) {
                        maxRoom = map[i][j];
                    }
                }
            }

            bw.write("#" + tc + " " + maxRoom + " " + maxCnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
