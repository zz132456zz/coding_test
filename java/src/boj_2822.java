// 백준 2822 - 점수 계산

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_2822 {

    public static class set implements Comparable<set> {
        int score;
        int num;

        public set(int score, int num) {
            this.score = score;
            this.num = num;
        }

        @Override
        public int compareTo(set o) {
            return o.score - this.score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        int[] ansArr = new int[5];

        set[] data = new set[8];
        for (int i = 0; i < 8; i++) {
            data[i] = new set(Integer.parseInt(br.readLine()), i + 1);
        }

        Arrays.sort(data);

        for (int i = 0; i < 5; i++) {
            answer += data[i].score;
            ansArr[i] = data[i].num;
        }

        Arrays.sort(ansArr);
        for (int i = 0; i < 5; i++) {
            sb.append(ansArr[i]).append(" ");
        }

        System.out.println(answer);
        System.out.println(sb);
    }

}
