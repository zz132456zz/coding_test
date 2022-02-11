// 백준 16926 - 배열 돌리기 1

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16926 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i = 0;i<N;i++) {
            st=new StringTokenizer(br.readLine()," ");
            for(int j =0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int standard = (N>M)?(int)(M/2):(int)(N/2);
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i =0;i<standard;i++) {	//0 1
            queue.clear();
            //2차원 배열 1차원 배열에 넣어주기
            for(int x = 0+i; x<(M-1)-i; x++) queue.offer(map[0+i][x]);
            for(int y = 0+i; y<(N-1)-i; y++) queue.offer(map[y][M-1-i]);
            for(int x = (M-1)-i; x>0+i; x--) queue.offer(map[N-1-i][x]);
            for(int y = (N-1)-i; y>0+i; y--) queue.offer(map[y][0+i]);

            //회전
            for(int r=0;r<R;r++){
                queue.offer(queue.poll());
            }
            //1차원 배열에서 다시 2차원 배열로 넣기
            for(int x = 0+i; x<(M-1)-i; x++) map[0+i][x] = queue.poll();
            for(int y = 0+i; y<(N-1)-i; y++) map[y][M-1-i] = queue.poll();
            for(int x = (M-1)-i; x>0+i; x--) map[N-1-i][x] = queue.poll();
            for(int y = (N-1)-i; y>0+i; y--) map[y][0+i] = queue.poll();
        }

        for(int i =0;i<N;i++) {
            for(int j =0;j<M;j++) {
                bw.write(map[i][j]+" ");
            }
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }



    // dfs로 시작해서 성공은했으나 비추합니다..
	/*
	static class Loc {
		int x;
		int y;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int N;
	static int M;
	static int[][] data;
	static boolean[][] visited;
	static int[][] delta = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	static Loc start;
	static int now;

	public static void dfs(Loc loc, int d) {  // 현재위치를 기준으로 네모모양으로만 도는 dfs
		int dx = loc.x + delta[d][0];
		int dy = loc.y + delta[d][1];
		if (0 <= dx && dx < N && 0 <= dy && dy < M) {  // 유효하고
			if (visited[dx][dy] && start.x == dx && start.y == dy) {  // 방문한곳인데 그게 출발점이면
				int temp = data[dx][dy];  // 다음 위치의 값을 기억시켜 놓고 한칸씩 밀어서 저장
				data[dx][dy] = now;
				now= temp;
				return;
			} else if (!visited[dx][dy]) {  // 방문하지 않은 곳이면
				visited[dx][dy] = true;  // 방문처리
				int temp = data[dx][dy];  // 다음 위치의 값을 기억시켜 놓고 한칸씩 밀어서 저장
				data[dx][dy] = now;
				now= temp;
				dfs(new Loc(dx, dy), d);  // 방향은 그대로 dfs
			} else {
				visited[loc.x][loc.y] = true;  // 방문처리
				dfs(loc, (d + 1) % 4);  // 반시계방향으로 방향 바꿔서 dfs
			}
		} else {  // 벽을 만나면 방향바꾸기
			visited[loc.x][loc.y] = true;  // 방문처리
			dfs(loc, (d + 1) % 4);  // 반시계 방향으로 방향 바꿔서 dfs
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		data = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < R; r++) {  // R번 회전
			visited = new boolean[N][M];  // 방문 배열 초기화
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visited[i][j]) {  // 방문하지 않았으면
						visited[i][j] = true;  // 방문처리
						start = new Loc(i, j);  // 돌리는 출발지점 저장
						now = data[i][j];  // 현재위치의 값 저장
						dfs(start, 0);  // dfs시작 (시작위치, 방향)
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bw.write(data[i][j] + " ");
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}
	*/
}
