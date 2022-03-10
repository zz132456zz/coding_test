// 백준 11729 - 하노이 탑 이동 순서

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11729 {

    static int cnt;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        cnt = 0;

        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 2, 3);

        System.out.println(cnt);
        System.out.print(sb.toString());
    }

    public static void hanoi(int N, int from, int mid, int to) {
        if (N == 1) {
            cnt++;
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        hanoi(N - 1, from, to, mid);
        hanoi(1, from, mid, to);
        hanoi(N - 1, mid, from, to);
    }

}
