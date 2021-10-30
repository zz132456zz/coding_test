// 백준 17219 - 비밀번호 찾기

import java.util.HashMap;
import java.util.Scanner;

public class boj_17219 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(scanner.next(), scanner.next());
        }

        for (int i = 0; i < M; i++) {
            System.out.println(map.get(scanner.next()));
        }
    }
}
