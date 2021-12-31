// 백준 11931 - 수 정렬하기 4

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boj_11931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            bw.write(arr.get(i) + "\n");
        }
        bw.flush();
        bw.close();
    }

}
