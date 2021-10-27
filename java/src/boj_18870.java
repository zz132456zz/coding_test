// 백준 18870 - 좌표 압축

import java.util.*;

public class boj_18870 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] data = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int X = scanner.nextInt();
            data[i] = X;
        }

        int[] sdata = data.clone();
        Arrays.sort(sdata);

        int num = 0;
        int before = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (sdata[i] != before) {
                map.put(sdata[i], num++);
            }
            before = sdata[i];
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(map.get(data[i]));
            sb.append(" ");
        }

        System.out.println(sb);
    }

}
