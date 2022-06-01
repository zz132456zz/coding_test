// 프로그래머스 86051 - 없는 숫자 더하기

public class programmers_86051 {

    public static int solution(int[] numbers) {
        int answer = 0;

        boolean[] check = new boolean[10];

        for (int num : numbers) {
            check[num] = true;
        }

        for (int i = 0; i < 10; i++) {
            if (!check[i]) {
                answer += i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};
        int result = solution(numbers);

        System.out.println(result);
    }

}
