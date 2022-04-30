// 백준 1043 - 거짓말

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1043 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int truth = Integer.parseInt(st.nextToken());
        Set<Integer> knowList = new HashSet<>();
        for (int i = 0; i < truth; i++) {
            int temp = Integer.parseInt(st.nextToken());
            knowList.add(temp);
        }

        int[][] party = new int[M][];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            party[i] = new int[temp];
            for (int j = 0; j < temp; j++) {
                party[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] checked = new boolean[M];
        boolean flag = true;

        while (flag) {
            flag = false;

            here : for (int i = 0; i < M; i++) {
                if (checked[i]) continue;

                for (int j = 0; j < party[i].length; j++) {
                    if (knowList.contains(party[i][j])) {
                        flag = true;
                        checked[i] = true;
                        for (int k = 0; k < party[i].length; k++) {
                            knowList.add(party[i][k]);
                        }
                        break here;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < checked.length; i++) {
            if (!checked[i]) answer++;
        }

        System.out.println(answer);
    }

}
