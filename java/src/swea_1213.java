// SWEA 1213 - String

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1213 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            String str = br.readLine();
            String data = br.readLine();
            int cnt = 0;
            int len = data.length() - str.length() + 1;
            int strLen = str.length();

            for (int i = 0; i < len; i++) {
                if (data.substring(i, i + strLen).equals(str)) cnt++;
            }

            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }

        System.out.print(sb);
    }

}
