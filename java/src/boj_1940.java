// 백준 1940 - 주몽

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1940 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            data.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(data);

        for (int i = 0; i < N; i++) {
            if (data.contains(M - data.get(i))) answer++;
        }

        System.out.println(answer / 2);
    }

}
