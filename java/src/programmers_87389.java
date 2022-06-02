// 프로그래머스 87389 - 나머지가 1이 되는 수 찾기

public class programmers_87389 {

    public static int solution(int n) {
        for (int i = 1; i < n; i++) {
            if (n % i == 1) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int n = 12;
        int result = solution(n);

        System.out.println(result);
    }

}
