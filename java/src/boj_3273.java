// 백준 3273 - 두 수의 합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_3273 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
            set.add(num);
        }
        int x = Integer.parseInt(br.readLine());

        Collections.sort(list, Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            if (set.contains(x - list.get(i))) answer++;
        }

        System.out.println(answer / 2);
    }

}
