// SWEA 8821 - 적고 지우기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class swea_8821 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String data = br.readLine();
            int answer = 0;
            boolean[] visited = new boolean[10];
            for (int i = 0; i < data.length(); i++) {
                int n = data.charAt(i) - '0';
                visited[n] = visited[n] ? false : true;
            }

            for (int i = 0; i < 10; i++) {
                if (visited[i]) {
                    answer++;
                }
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
