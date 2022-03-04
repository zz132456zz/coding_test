// 백준 9498 - 시험 성적

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9498 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int score = Integer.parseInt(br.readLine());

        char grade = 'F';

        if (score >= 90) {
            grade = 'A';
        } else if (score >= 80) {
            grade = 'B';
        } else if (score >= 70) {
            grade = 'C';
        } else if (score >= 60) {
            grade = 'D';
        }

        System.out.println(grade);
    }

}
