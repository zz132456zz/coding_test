// 백준 2866 - 문자열 잘라내기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        List<StringBuilder> data = new ArrayList<>();
        for (int i = 0; i < C; i++) {
            data.add(new StringBuilder());
        }

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                data.get(j).append(str.charAt(j));
            }
        }

        for (int i = 0; i < C; i++) {
            data.get(i).reverse();
        }

        for (int i = 0; i < R - 1; i++) {
            Set<String> set = new HashSet<>();

            for (int j = 0; j < C; j++) {
                data.get(j).setLength(data.get(j).length() - 1);
                set.add(data.get(j).toString());
            }

            if (set.size() == C) {
                answer++;
            } else {
                break;
            }
        }

        System.out.println(answer);
    }


}
