// 백준 11728 - 배열 합치기

import java.io.*;
import java.util.*;

public class boj_11728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);

        for (int i = 0; i < N + M - 1; i++) {
            bw.write(arr.get(i) + " ");
        }
        bw.write(arr.get(N + M - 1) + "\n");

        bw.flush();
        bw.close();
    }

}
