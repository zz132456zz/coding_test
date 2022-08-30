// 백준 4358 - 생태학

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_4358 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        String str = null;

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int cnt = 0;

        while (true) {
            str = br.readLine();
            if(str == null || str.length() == 0) break;

            cnt++;
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
                list.add(str);
            }
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            double n = (double) map.get(list.get(i)) / cnt * 100;
            answer.append(list.get(i)).append(" ").append(String.format("%.4f",n)).append("\n");
        }

        System.out.print(answer);
    }

}
