// 백준 2504 - 괄호의 값

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        if (isCorrect(S)) {
            System.out.println(cal(S));
        } else {
            System.out.println(0);
        }
    }

    public static boolean isCorrect(String S) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (stack.isEmpty()) {
                stack.add(S.charAt(i));
                continue;
            }

            char top = stack.peek();
            char c = S.charAt(i);

            if (top == '(' && c == ')') {
                stack.pop();
            } else if (top == '[' && c == ']') {
                stack.pop();
            } else {
                stack.add(c);
            }
        }

        return stack.isEmpty();
    }

    public static int cal(String S) {
        Stack<Character> stack = new Stack<>();

        int mul = 1;
        int result = 0;

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (c == '(') {
                stack.add('(');
                mul *= 2;
            } else if (c == ')') {
                if (S.charAt(i - 1) == '(') result += mul;
                stack.pop();
                mul /= 2;
            } else if (c == '[') {
                stack.add('(');
                mul *= 3;
            } else if (c == ']') {
                if (S.charAt(i - 1) == '[') result += mul;
                stack.pop();
                mul /= 3;
            }
        }

        return result;
    }

}
