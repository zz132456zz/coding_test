// 백준 1417 - 국회의원 선거

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class boj_1417 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
        int N = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());
        if (N != 1) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < N - 1; i++) {
                pq.add(Integer.parseInt(br.readLine()));
            }

            int cnt = 0;

            while(pq.peek() >= dasom) {
                dasom++;
                pq.add(pq.poll() - 1);
                cnt++;
            }

            System.out.println(cnt);
        } else {
            System.out.println(0);
        }



    }

}
