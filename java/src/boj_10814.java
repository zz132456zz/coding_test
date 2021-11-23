// 백준 10814 - 나이순 정렬

import java.io.*;
import java.util.*;

public class boj_10814 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            if (map.containsKey(age)) {
                map.get(age).add(name);
            } else {
                map.put(age, new ArrayList<>(Arrays.asList(name)));
            }
        }

        for (int i = 1; i <= 200; i++) {
            if (map.containsKey(i)) {
                List<String> temp = map.get(i);

                for (int j = 0; j < temp.size(); j++) {
                    bw.write(i + " " + temp.get(j) + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
