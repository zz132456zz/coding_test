// 프로그래머스 77885 - 2개 이하로 다른 비트

import java.util.Arrays;

public class programmers_77885 {

    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            answer[i] = calc(numbers[i]);
        }

        return answer;
    }

    public static long calc(long number) {
        char[] arr = ("0" + Long.toBinaryString(number)).toCharArray();
        int len = arr.length;

        int idx = 0;

        for (int i = len - 1; i >= 0; i--) {
            if (arr[i] == '0') {
                arr[i] = '1';
                idx = i;
                break;
            }
        }

        for (int i = idx + 1; i < len; i++) {
            if (arr[i] == '1') {
                arr[i] = '0';
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(arr);

        return Long.parseLong(sb.toString(),2);
    }

    public static void main(String[] args) {
        long[] numbers = {2, 7};
        long[] result = solution(numbers);

        System.out.println(Arrays.toString(result));
    }

}
