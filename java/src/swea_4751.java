// SWEA 4751 - 다솔이의 다이아몬드 장식

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4751 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        String[] line = {"..#..", ".#.#.", "#.*.#", ".#.#.", "..#.."};

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String str = br.readLine();

            for (int i = 0; i < 5; i++) {
                StringBuilder temp = new StringBuilder();
                if (i == 2) {
                    for (int j = 0; j < str.length(); j++) {
                        String replace = line[i].replace('*',str.charAt(j));
                        if (temp.length() > 0) temp.setLength(temp.length() - 1);
                        temp.append(replace);
                    }
                    sb.append(temp).append("\n");
                } else {
                    for (int j = 0; j < str.length(); j++) {
                        if (temp.length() > 0) temp.setLength(temp.length() - 1);
                        temp.append(line[i]);
                    }
                    sb.append(temp).append("\n");
                }
            }
        }

        System.out.println(sb);
    }

}
