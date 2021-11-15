// 백준 7662 - 이중 우선순위 큐

import java.util.*;

public class boj_7662 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();

            int k = scanner.nextInt();
            for (int i = 0; i < k; i++) {
                String cmd = scanner.next();
                int num = scanner.nextInt();

                if (cmd.equals("I")) {
                    if (map.containsKey(num)) {
                        map.put(num, map.get(num) + 1);
                    } else {
                        map.put(num, 1);
                    }
                } else if (cmd.equals("D")) {
                    if (map.size() != 0) {
                        if (num == 1) {
                            if (map.lastEntry().getValue() == 1) {
                                map.pollLastEntry();
                            } else {
                                map.put(map.lastEntry().getKey(), map.lastEntry().getValue() - 1);
                            }
                        } else if (num == -1) {
                            if (map.firstEntry().getValue() == 1) {
                                map.pollFirstEntry();
                            } else {
                                map.put(map.firstEntry().getKey(), map.firstEntry().getValue() - 1);
                            }
                        }
                    }
                }
            }

            if (map.size() == 0) {
                System.out.println("EMPTY");
            } else {
                System.out.print(map.lastKey());
                System.out.print(" ");
                System.out.println(map.firstKey());
            }
        }
    }
}
