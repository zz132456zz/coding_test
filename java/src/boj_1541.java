// 백준 1541 - 잃어버린 괄호

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_1541 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.next();
        List<Integer> num = new ArrayList<>();
        List<String> oper = new ArrayList<>();

        int idx = -1;
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == '+' || data.charAt(i) == '-') {
                num.add(Integer.parseInt(data.substring(idx + 1, i)));
                oper.add(Character.toString(data.charAt(i)));
                idx = i;
            }
        }
        num.add(Integer.parseInt(data.substring(idx + 1)));

        int left = 0;
        int right = 0;
        if (oper.indexOf("-") == -1) {
            for (int i = 0; i < num.size(); i++) {
                left += num.get(i);
            }
        } else {
            int minus = oper.indexOf("-");
            for (int i = 0; i <= minus; i++) {
                left += num.get(i);
            }
            for (int i = minus + 1; i < num.size(); i++) {
                right += num.get(i);
            }
        }

        System.out.println(left - right);
    }
}
