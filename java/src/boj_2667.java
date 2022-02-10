// 백준 2667 - 단지번호붙이기

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class boj_2667 {

    // bfs
    static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[][] data = new char[N][N];
        for (int i = 0; i < N; i++) {
            data[i] = br.readLine().toCharArray();
        }

        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (data[i][j] == '0') visited[i][j] = true;
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    int house = 1;
                    Queue<Location> q = new LinkedList<>();
                    q.offer(new Location(i, j));
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        int x = q.peek().x;
                        int y = q.poll().y;
                        for (int k = 0; k < 4; k++) {
                            int _x = x + delta[k][0];
                            int _y = y + delta[k][1];
                            if (0 <= _x && _x < N && 0 <= _y && _y < N) {
                                if (!visited[_x][_y]) {
                                    q.offer(new Location(_x, _y));
                                    visited[_x][_y] = true;
                                    house++;
                                }
                            }
                        }
                    }
                    answer.add(house);
                }
            }
        }

        Collections.sort(answer);
        bw.write(answer.size() + "\n");
        for (int ans : answer) {
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

	/*
	// dfs
	static boolean[][] visited;
	static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static int house;
	static int N;

	static class Location {
		int x;
		int y;

		public Location(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void dfs(Location loc) {
		int x = loc.x;
		int y = loc.y;
		for (int k = 0; k < 4; k++) {
			int _x = x + delta[k][0];
			int _y = y + delta[k][1];
			if (0 <= _x && _x < N && 0 <= _y && _y < N) {
				if (!visited[_x][_y]) {
					visited[_x][_y] = true;
					dfs(new Location(_x, _y));
					house++;
				}
			}
		}

	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		char[][] data = new char[N][N];
		for (int i = 0; i < N; i++) {
			data[i] = br.readLine().toCharArray();
		}

		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (data[i][j] == '0') visited[i][j] = true;
			}
		}

		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					house = 1;
					visited[i][j] = true;
 					dfs(new Location(i, j));
					answer.add(house);
				}
			}
		}

		Collections.sort(answer);
		bw.write(answer.size() + "\n");
		for (int ans : answer) {
			bw.write(ans + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	*/

}
