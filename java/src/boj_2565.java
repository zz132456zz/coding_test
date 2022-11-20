// 백준 2565 - 전깃줄

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_2565 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        int[][] data = new int[N][2];
        ArrayList<ArrayList<Integer>> cntList = new ArrayList<>();
        int[] cnt = new int[N + 1];
        for (int i = 0; i < N; i++) {
            cntList.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isCross(data[i], data[j])) {
                    cntList.get(i).add(j);
                    cntList.get(j).add(i);
                    cnt[i]++;
                    cnt[j]++;
                }
            }
        }

        while (true) {
            int max = Integer.MIN_VALUE;
            int maxIdx = -1;

            for (int i = 0; i < N; i++) {
                if (cnt[i] > max) {
                    max = cnt[i];
                    maxIdx = i;
                }
            }

            if (max == 0) break;

            cnt[maxIdx] = 0;
            for (int idx : cntList.get(maxIdx)) {
                if (idx == N) continue;
                int removeIdx = cntList.get(idx).indexOf(maxIdx);
                cntList.get(idx).set(removeIdx, N);
                cnt[idx]--;
            }
            answer++;
        }

        System.out.println(answer);
    }

    public static boolean isCross(int[] a, int[] b) {
        if (a[0] < b[0] && a[1] > b[1]) return true;
        if (a[0] > b[0] && a[1] < b[1]) return true;
        return false;
    }

}
