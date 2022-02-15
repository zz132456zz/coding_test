// 백준 2635 - 수 이어가기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj_2635 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Integer> data = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            List<Integer> temp = new ArrayList<>();

            temp.add(N);
            temp.add(i);
            int idx = 1;
            while (temp.get(idx - 1) - temp.get(idx) >= 0) {
                temp.add(temp.get(idx - 1) - temp.get(idx));
                idx++;
            }

            if (data.size() < temp.size()) data = temp;

        }

        sb.append(data.size()).append("\n");
        for (int i = 0, size = data.size(); i < size; i++) {
            sb.append(data.get(i)).append(" ");
        }

        System.out.println(sb.toString());
    }

}
