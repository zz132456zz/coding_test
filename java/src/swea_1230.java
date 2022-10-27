// SWEA 1230 - 암호문3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class swea_1230 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Integer> code = new ArrayList<>();
//            LinkedList<Integer> code = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                code.add(Integer.parseInt(st.nextToken()));
            }
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                String cmd = st.nextToken();
                if ("I".equals(cmd)) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < y; j++) {
                        int s = Integer.parseInt(st.nextToken());
                        code.add(x + j, s);
                    }
                } else if ("D".equals(cmd)) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < y; j++) {
                        code.remove(x);
                    }
                } else {
                    int y = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < y; j++) {
                        int s = Integer.parseInt(st.nextToken());
                        code.add(s);
                    }
                }
            }

            sb.append("#").append(tc);
            for (int i = 0; i < 10; i++) {
                sb.append(" ").append(code.get(i));
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

}
