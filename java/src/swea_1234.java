// SWEA 1234 - 비밀번호

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1234 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            boolean flag = true;

            while (flag) {
                flag = false;
                for (int i = 0; i < 10; i++) {
                    if (str.contains(i + "" + i)) {
                        str = str.replaceAll(i + "" + i, "");
                        flag = true;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(str).append("\n");
        }

        System.out.print(sb);
    }

}
