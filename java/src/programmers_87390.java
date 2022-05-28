// 프로그래머스 87390 - n^2 배열 자르기

import java.util.Arrays;

public class programmers_87390 {

    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];

        for (long i = left; i <= right; i++) {
            int[] loc = findLoc(n, i);
            int num = Math.max(loc[0], loc[1]) + 1;
            answer[(int) (i - left)] = num;
        }

        return answer;
    }

    public static int[] findLoc(int n, long num) {
        int[] temp = new int[2];
        temp[0] = (int) (num / n);
        temp[1] = (int) (num % n);
        return temp;
    }

    public static void main(String[] args) {
        int n = 4;
        long left = 7;
        long right = 14;
        int[] result = solution(n, left, right);

        System.out.println(Arrays.toString(result));
    }

}
