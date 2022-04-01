// 백준 1194 - 달이 차오른다, 가자.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1194 {
    static int N;
    static int M;
    static char[][] data;
    static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1 ,0}};

    public static int bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();

        boolean[][][] visited = new boolean[N][M][64];
        visited[start[0]][start[1]][0] = true;
        queue.add(new int[] {start[0], start[1], 1, 0});  // r, c, distance, 들고있는 key들

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + delta[i][0];
                int nc = now[1] + delta[i][1];
                if (0 <= nr && nr < N && 0 <= nc && nc < M && data[nr][nc] != '#' && !visited[nr][nc][now[3]]) {
                    if (data[nr][nc] == '.') {
                        visited[nr][nc][now[3]] = true;
                        queue.add(new int[] {nr, nc, now[2] + 1, now[3]});
                    } else if ('a' <= data[nr][nc] && data[nr][nc] <= 'f') {
                        int key = now[3] | (1 << data[nr][nc] - 'a');
                        visited[nr][nc][key] = true;
                        queue.add(new int[] {nr, nc, now[2] + 1, key});
                    } else if ('A' <= data[nr][nc] && data[nr][nc] <= 'F') {
                        if ((now[3] & (1 << data[nr][nc] - 'A')) != 0) {
                            visited[nr][nc][now[3]] = true;
                            queue.add(new int[] {nr, nc, now[2] + 1, now[3]});
                        }
                    } else if (data[nr][nc] == '1') {
                        return now[2];
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new char[N][M];
        int[] start = new int[2];
        for (int i = 0; i < N; i++) {
            data[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (data[i][j] == '0') {  // 민석이의 현재 위치
                    start[0] = i;
                    start[1] = j;
                    data[i][j] = '.';
                }
            }
        }

        int answer = bfs(start);

        System.out.println(answer);
    }

}
