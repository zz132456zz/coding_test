// 백준 13335 - 트럭

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_13335 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] truck = new int[n];
        for (int i = 0; i < n; i++) {
            truck[i] = Integer.parseInt(st.nextToken());
        }

        int sumWeight = 0;
        int time = 0;
        int nextIdx = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            queue.add(0);
        }

        while (true) {
            time++;
            sumWeight -= queue.poll();

            if (sumWeight + truck[nextIdx] <= L) {
                sumWeight += truck[nextIdx];
                queue.add(truck[nextIdx]);
                nextIdx++;
                if (nextIdx == n) {
                    time += w;
                    break;
                }
            } else {
                queue.add(0);
            }
        }

        System.out.println(time);
    }

}
