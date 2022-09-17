// SWEA 1215 - 회문1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1215 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int answer = 0;
            int N = Integer.parseInt(br.readLine());
            String[] data1 = new String[8];
            String[] data2 = new String[8];

            for (int i = 0; i < 8; i++) {
                data1[i] = br.readLine();
            }
            for (int i = 0; i < 8; i++) {
                data2[i] = "";
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8 - N + 1; j++) {
                    StringBuilder temp = new StringBuilder(data1[i].substring(j, j + N));

                    if (temp.toString().equals(temp.reverse().toString())) {
                        answer++;
                    }
                }
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    data2[j] += data1[i].charAt(j);
                }
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8 - N + 1; j++) {
                    StringBuilder temp = new StringBuilder(data2[i].substring(j, j + N));

                    if (temp.toString().equals(temp.reverse().toString())) {
                        answer++;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

}
