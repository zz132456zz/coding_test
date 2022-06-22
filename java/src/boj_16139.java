// 백준 16139 - 인간-컴퓨터 상호작용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16139 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder answer = new StringBuilder();

        String S = br.readLine();
        int q = Integer.parseInt(br.readLine());
        int[][] map = new int[S.length()][26];
        map[0][S.charAt(0) - 'a'] = 1;
        for (int i = 1; i < S.length(); i++) {
            for (int j = 0; j < 26; j++) {
                map[i][j] = map[i - 1][j];
            }
            map[i][S.charAt(i) - 'a']++;
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int cnt = 0;

            if (l == 0) {
                cnt = map[r][a - 'a'];
            } else {
                cnt = map[r][a - 'a'] - map[l - 1][a - 'a'];
            }

            answer.append(cnt).append("\n");
        }

        System.out.print(answer);
    }

}
