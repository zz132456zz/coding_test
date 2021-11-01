// 백준 9375 - 패션왕 신해빈

import java.util.HashMap;
import java.util.Scanner;

public class boj_9375 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String name = scanner.next();
                String cloth = scanner.next();

                if (map.containsKey(cloth)) {
                    map.put(cloth, map.get(cloth) + 1);
                } else {
                    map.put(cloth, 1);
                }
            }

            int answer = 1;
            for (String key : map.keySet()) {
                answer *= map.get(key) + 1;
            }
            System.out.println(answer - 1);
        }
    }
}
