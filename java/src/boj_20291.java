// 백준 20291 - 파일 정리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class boj_20291 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String extension = br.readLine().split("\\.")[1];

            if (map.containsKey(extension)) {
                map.put(extension, map.get(extension) + 1);
            } else {
                map.put(extension, 1);
            }
        }

        String[] answer = map.keySet().toArray(new String[0]);
        Arrays.sort(answer);

        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i]).append(" ").append(map.get(answer[i])).append("\n");
        }

        System.out.print(sb);
    }

}
