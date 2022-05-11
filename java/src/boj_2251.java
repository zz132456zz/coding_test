// 백준 2251 - 물통

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2251 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] ABC = new int[3];
        ABC[0] = Integer.parseInt(st.nextToken());
        ABC[1] = Integer.parseInt(st.nextToken());
        ABC[2] = Integer.parseInt(st.nextToken());

        boolean[][][] visited = new boolean[ABC[0] + 1][ABC[1] + 1][ABC[2] + 1];
        boolean[] answer = new boolean[ABC[2] + 1];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, ABC[2]});
        visited[0][0][ABC[2]] = true;
        answer[ABC[2]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 3; i++) {
                if (cur[i] == 0) continue;

                for (int j = 0; j < 3; j++) {
                    if (i == j) continue;

                    int[] temp = cur.clone();
                    if (cur[i] <= ABC[j] - cur[j]) {
                        temp[j] += temp[i];
                        temp[i] = 0;
                    } else {
                        temp[i] -= ABC[j] - cur[j];
                        temp[j] = ABC[j];
                    }

                    if (!visited[temp[0]][temp[1]][temp[2]]) {
                        visited[temp[0]][temp[1]][temp[2]] = true;
                        queue.add(new int[] {temp[0], temp[1], temp[2]});
                        if (temp[0] == 0) answer[temp[2]] = true;
                    }
                }
            }
        }

        for (int i = 0; i <= ABC[2]; i++) {
            if (answer[i]) sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

}
