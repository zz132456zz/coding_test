// SWEA 1983 - 조교의 성적 매기기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class swea_1983 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            List<Integer> data = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int temp = 0;
                temp += Integer.parseInt(st.nextToken()) * 35;
                temp += Integer.parseInt(st.nextToken()) * 45;
                temp += Integer.parseInt(st.nextToken()) * 20;
                data.add(temp);
            }

            int K_score = data.get(K - 1);
            data.sort(Collections.reverseOrder());

            sb.append(grade[data.indexOf(K_score) / (N / 10)]).append("\n");
        }

        System.out.print(sb);
    }

}
