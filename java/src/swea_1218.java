// SWEA 1218 - 괄호 짝짓기

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class swea_1218 {
    static int len;
    static char[] data;
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int tc = 1; tc <= 10; tc++) {
            len = Integer.parseInt(br.readLine());
            data = br.readLine().toCharArray();
            stack = new Stack<>();

            bw.write("#" + tc + " " + (check() ? "1" : "0") + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean check() {
        for (int i = 0; i < len; i++) {
            if (data[i] == '(' || data[i] == '[' || data[i] == '{' || data[i] == '<') {
                stack.push(data[i]);
            } else {
                if (!stack.isEmpty()) {
                    char now = stack.pop();
                    if (now == '(' && data[i] != ')') {
                        return false;
                    } else if (now == '[' && data[i] != ']') {
                        return false;
                    } else if (now == '{' && data[i] != '}') {
                        return false;
                    } else if (now == '<' && data[i] != '>') {
                        return false;
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
