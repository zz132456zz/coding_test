// 백준 1620 - 나는야 포켓몬 마스터 이다솜

import java.util.HashMap;
import java.util.Scanner;

public class boj_1620 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        HashMap<String, Integer> hashMap_name_key = new HashMap<>();
        HashMap<Integer, String> hashMap_num_key = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = scanner.next();
            hashMap_num_key.put(i, name);
            hashMap_name_key.put(name, i);
        }

        for (int i = 0; i < M; i++) {
            String cmd = scanner.next();
            try {
                System.out.println(hashMap_num_key.get(Integer.parseInt(cmd)));
            } catch (Exception e) {
                System.out.println(hashMap_name_key.get(cmd));
            }
        }

    }

}
