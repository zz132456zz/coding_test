// SWEA 1263 - 사람 네트워크2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1263 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] data = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if (i == j) {  // 자신에서 자신으로 가는 거리는 0
                        data[i][j] = 0;
                    } else if (temp == 0) {  // 연결이 되어있지 않으면 충분히 큰수로 초기화
                        data[i][j] = Integer.MAX_VALUE / 2;
                    } else {  // 연결되어 있으면 거리만큼 초기화(이문제에서는 다 1)
                        data[i][j] = temp;
                    }
                }
            }

            // 플로이드워셜 시작
            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        data[i][j] = Math.min(data[i][j], data[i][k] + data[k][j]);
                    }
                }
            }

            // 사용자마다 Closeness Centrality(CC)를 계산해서 가장 작은 값 찾기
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    sum += data[i][j];
                }
                if (sum < min) {
                    min = sum;
                }
            }

            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }

        System.out.println(sb);
    }

}
