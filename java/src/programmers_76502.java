// 프로그래머스 76502 - 괄호 회전하기

public class programmers_76502 {

    public static int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1) + s.charAt(0);
            if (isCorrect(s)) answer++;
        }

        return answer;
    }

    public static boolean isCorrect(String s) {
        boolean flag = true;
        while (flag) {
            flag = false;
            if (s.contains("()")) {
                s = s.replaceAll("\\(\\)","");
                flag = true;
            }
            if (s.contains("[]")) {
                s = s.replaceAll("\\[]", "");
                flag = true;
            }
            if (s.contains("{}")) {
                s = s.replaceAll("\\{}", "");
                flag = true;
            }
        }

        if (s.length() == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "[](){}";
        int result = solution(s);

        System.out.println(result);
    }

}
