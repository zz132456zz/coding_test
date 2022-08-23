public class programmers_test_3_1 {

    public static int solution(int a, int b, int n) {
        int answer = 0;

        while (n >= a) {
            answer += (n / a) * b;
            n = (n / a) * b + n % a;
        }

        return answer;
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 1;
        int n = 20;
        int result = solution(a, b, n);

        System.out.println(result);
    }

}
