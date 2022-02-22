// 백준 2961 - 도영이가 만든 맛있는 음식

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2961 {

    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] data = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;
        subSet(data);
        System.out.println(min);
    }

    public static void subSet(int[][] data) {
        int N = data.length;

        for (int flag = 1, caseCount = 1 << N; flag < caseCount; flag++) {
            List<Integer> temp = new ArrayList<>();
            int sour = 1;
            int bitter = 0;

            for (int i =0; i < N; i++) {
                if ((flag & 1 << i) != 0) {
                    temp.add(i);
                }
            }

            for (int i : temp) {
                sour *= data[i][0];
                bitter += data[i][1];
            }

            int diff = Math.abs(sour - bitter);
            if (min > diff) min = diff;
        }
    }

}
