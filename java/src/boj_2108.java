// 백준 2108 - 통계학

import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class boj_2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        List<Integer> arr = new LinkedList<>();
        int[] cnt = new int[8001];
        double sum = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr.add(num);
            sum += num;
            cnt[num + 4000]++;
        }

        arr.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1- o2;
            }
        });

        List<Integer> mode = new LinkedList<>();
        int max = -1;
        for (int i = 0; i < 8001; i++) {
            if (max < cnt[i]) {
                max = cnt[i];
            }
        }

        for (int i = 0; i < 8001; i++) {
            if (max == cnt[i]) {
                mode.add(i - 4000);
            }
        }

        bw.write(Math.round(sum / N) + "\n");
        bw.write(arr.get(arr.size() / 2) + "\n");
        bw.write((mode.size() == 1 ? mode.get(0) : mode.get(1)) + "\n");
        bw.write(arr.get(arr.size() - 1) - arr.get(0) + "\n");

        bw.flush();
        bw.close();
    }
}