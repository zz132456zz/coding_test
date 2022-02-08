// SWEA 1228 - 암호문1

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_1228 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int tc = 1; tc <= 10; tc++) {
            int len = Integer.parseInt(br.readLine());

            List<String> data = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < len; i++) {
                data.add(st.nextToken());
            }

            int cmdNum = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < cmdNum; i++) {
                st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                List<String> addList = new LinkedList<>();
                for (int j = 0; j < y; j++) {
                    addList.add(st.nextToken());
                }
                data.addAll(x, addList);
            }

            bw.write("#" + tc);
            for (int i = 0; i < 10; i++) {
                bw.write(" " + data.get(i));
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
