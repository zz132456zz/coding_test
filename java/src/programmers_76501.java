// 프로그래머스 76501 - 음양 더하기

public class programmers_76501 {

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        int n = absolutes.length;

        for (int i = 0; i < n; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] absolutes = {4, 7, 12};
        boolean[] signs = {true, false, true};
        int result = solution(absolutes, signs);

        System.out.println(result);
    }

}
