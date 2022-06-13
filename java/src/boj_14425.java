// 백준 14425 - 문자열 집합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_14425 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> S = new ArrayList<>();
        for (int i = 0; i < N; i++) {
           S.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            if (S.contains(br.readLine())) {
                answer++;
            }
        }

        System.out.println(answer);
    }

}
