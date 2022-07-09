// 백준 2002 - 추월

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj_2002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        int N = Integer.parseInt(br.readLine());

        List<String> in = new ArrayList<>();
        List<String> out = new ArrayList<>();
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            in.add(br.readLine());
        }
        for (int i = 0; i < N; i++) {
            out.add(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            String cur = in.get(i);
            for (int j = 0; j < N; j++) {
                if (out.get(j).equals(cur)) {
                    visited[j] = true;
                    break;
                }

                if (visited[j]) continue;
                visited[j] = true;
                answer++;
            }
        }

        System.out.println(answer);
    }

}
