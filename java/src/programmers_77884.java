// 프로그래머스 77884 - 약수의 개수와 덧셈

public class programmers_77884 {

    public static int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int temp = (int) Math.pow(i, 0.5);
            if (i == temp * temp) {
                answer -= i;
            } else {
                answer += i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int left = 13;
        int right = 17;
        int result = solution(left,right);

        System.out.println(result);
    }

}
