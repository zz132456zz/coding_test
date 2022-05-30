// 프로그래머스 81301 - 숫자 문자열과 영단어

public class programmers_81301 {

    public static int solution(String s) {
        String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < 10; i++) {
            s = s.replaceAll(number[i], Integer.toString(i));
        }

        int answer = Integer.parseInt(s);

        return answer;
    }

    public static void main(String[] args) {
        String s = "one4seveneight";
        int result = solution(s);

        System.out.println(result);
    }

}
