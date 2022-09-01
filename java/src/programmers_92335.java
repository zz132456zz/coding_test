// 프로그래머스 92335 - k진수에서 소수 개수 구하기

public class programmers_92335 {

    public static int solution(int n, int k) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();

        String conversion = Integer.toString(n, k);

        for (int i = 0; i < conversion.length(); i++) {
            if (conversion.charAt(i) == '0') {
                if (sb.length() != 0) {
                    if (isPrime(sb)) {
                        answer++;
                    }
                    sb.setLength(0);
                }
            } else {
                sb.append(conversion.charAt(i));
            }
        }

        if (sb.length() != 0) {
            if (isPrime(sb)) {
                answer++;
            }
        }

        return answer;
    }

    public static boolean isPrime(StringBuilder sb) {
        long num = Long.parseLong(sb.toString());
        if (num == 1) return false;
        for (int i = 2; i < (int) Math.sqrt(num) + 1; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 437674;
        int k = 3;
        int result = solution(n, k);

        System.out.println(result);
    }

}
