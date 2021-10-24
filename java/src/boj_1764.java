// 백준 1764 - 듣보잡

import java.util.*;

public class boj_1764 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> never_hear = new HashSet<>();
        List<String> never_hear_see = new ArrayList<>();

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            String name = scanner.next();
            never_hear.add(name);
        }

        for (int j = 0; j < M; j++) {
            String name = scanner.next();
            if (never_hear.contains(name)) {
                never_hear_see.add(name);
            }
        }

        Collections.sort(never_hear_see);

        System.out.println(never_hear_see.size());
        for (int i = 0; i < never_hear_see.size(); i++) {
            System.out.println(never_hear_see.get(i));
        }
    }

}
