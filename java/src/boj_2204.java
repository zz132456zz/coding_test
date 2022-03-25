// 백준 2204 - 도비의 난독증 테스트

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class boj_2204 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            String[] data = new String[n];
            for (int i = 0; i < n; i++) {
                data[i] = br.readLine();
            }

            Arrays.sort(data, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.toLowerCase().compareTo(o2.toLowerCase());
                }
            });

            sb.append(data[0]).append("\n");
        }

        System.out.print(sb);
    }

}
