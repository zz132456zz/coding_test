// 프로그래머스 92342 - 양궁대회

import java.util.Arrays;

public class programmers_92342 {

    static int[] selected = new int[11];
    static int[] plusOne;
    static int[] apeach;
    static int max;
    static int[] answer;

    public static int[] solution(int n, int[] info) {
        plusOne = new int[11];
        for (int i = 0; i < 11; i++) {
            plusOne[i] = info[i] + 1;
        }

        answer = new int[11];
        apeach = info;
        max = Integer.MIN_VALUE;

        select(0, n);

        if (max == Integer.MIN_VALUE) {
            answer = new int[] {-1};
        }

        return answer;
    }

    public static void select(int d, int n) {
        if (d == 11) {
            int cnt = count(selected);
            if (cnt > n) {
                return;
            } else if (cnt < n) {
                selected[10] += n - cnt;
            }

            compare(selected);

            return;
        }

        selected[d] = plusOne[d];
        select(d + 1, n);
        selected[d] = 0;
        select(d + 1, n);
    }

    public static void compare(int[] ryan) {
        int ryanScore = 0;
        int apeachScore = 0;

        for (int i = 0; i <= 10; i++) {
            if (apeach[i] == 0 && ryan[i] == 0) continue;
            if (apeach[i] < ryan[i]) {
                ryanScore += 10 - i;
            } else {
                apeachScore += 10 - i;
            }
        }

        if (ryanScore > apeachScore) {
            int diff = ryanScore - apeachScore;
            if (max < diff) {
                max = diff;
                answer = ryan.clone();
            } else if (max == diff) {
                for (int i = 10; i >= 0; i--) {
                    if (answer[i] < ryan[i]) {
                        answer= ryan.clone();
                        break;
                    } else if (answer[i] > ryan[i]) {
                        break;
                    }
                }
            }
        }
    }

    public static int count(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
//        int n = 5;
//        int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        int n = 1;
        int[] info = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//        int n = 9;
//        int[] info = {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};
//        int n = 10;
//        int[] info = {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};
        int[] result = solution(n, info);

        System.out.println(Arrays.toString(result));
    }

}
