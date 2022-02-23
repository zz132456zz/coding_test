// 백준 16236 - 아기 상어

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16236 {

    static class Shark {
        int row;
        int column;
        int size;
        int remain;

        public Shark(int row, int column, int size) {
            super();
            this.row = row;
            this.column = column;
            this.size = size;
        }
    }

    static class Location implements Comparable<Location>{
        int row;
        int column;

        public Location(int row, int column) {
            super();
            this.row = row;
            this.column = column;
        }

        @Override
        public int compareTo(Location o) {
            return this.row == o.row ? this.column - o.column : this.row - o.row;
        }
    }

    static Shark babyShark;
    static int N;
    static int[][] data;
    static int answer;
    static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        answer = 0;

        N = Integer.parseInt(br.readLine());
        data = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                if (data[i][j] == 9) {
                    babyShark = new Shark(i, j, 2);
                    babyShark.remain = 2;
                }
            }
        }

        while (bfs()) {}
        System.out.println(answer);
    }

    public static boolean bfs() {
        Queue<Location> queue = new LinkedList<>();
        PriorityQueue<Location> tempQueue = new PriorityQueue<>();
        int cnt = 0;

        boolean[][] visited = new boolean[N][N];

        queue.add(new Location(babyShark.row, babyShark.column));
        visited[babyShark.row][babyShark.column] = true;

        while (!queue.isEmpty()) {  // 지금 층에서 다음층을 우선순위큐에 넣기위해
            Location current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = current.row + delta[i][0];
                int y = current.column + delta[i][1];
                if (0 <= x && x < N && 0 <= y && y < N && !visited[x][y]) {  // 범위내이고
                    if (data[x][y] <= babyShark.size) {  // 지나갈수있고
                        tempQueue.add(new Location(x, y));
                        visited[x][y] = true;
                    }
                }
            }

            if (queue.isEmpty()) {  // 큐가 비어있으면 다음깊이에서 먹을수있는애있는지 찾기
                cnt++;
                while (!tempQueue.isEmpty()) {
                    Location now = tempQueue.poll();

                    if (data[now.row][now.column] > 0 && data[now.row][now.column] < babyShark.size) {
                        // 먹을수있다
                        data[babyShark.row][babyShark.column] = 0;
                        babyShark.row = now.row;
                        babyShark.column = now.column;
                        if (--babyShark.remain == 0) {
                            babyShark.size++;
                            babyShark.remain = babyShark.size;
                        }
                        data[now.row][now.column] = 0;
                        answer += cnt;
                        return true;
                    } else {
                        // 먹을수없다
                        queue.add(now);
                    }
                }
            }
        }

        return false;
    }

}
