import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class programmers_test_1_1 {

    public static String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();

        int[] xData = new int[10];
        int[] yData = new int[10];

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < X.length(); i++) {
            xData[X.charAt(i) - '0']++;
        }

        for (int i = 0; i < Y.length(); i++) {
            yData[Y.charAt(i) - '0']++;
        }

        for (int i = 0; i < 10; i++) {
            int x = xData[i];
            int y = yData[i];
            int min = Math.min(x, y);

            for (int j = 0; j < min; j++) {
                list.add(i);
            }
        }

        Collections.sort(list, Collections.reverseOrder());

        for (int i = 0; i < list.size(); i++) {
            answer.append(list.get(i));
        }

        if (answer.length() == 0) {
            return "-1";
        }

        if (list.get(0) == 0) {
            return "0";
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        String X = "";
        String Y = "123450";
        String result = solution(X, Y);

        System.out.println(result);
    }

}
